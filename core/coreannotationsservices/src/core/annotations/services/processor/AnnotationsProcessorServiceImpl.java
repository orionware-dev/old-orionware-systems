package core.annotations.services.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.processor.tasks.ApplyAnnotationToMethodTask;
import core.annotations.services.processor.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.processor.tasks.GatherAllObjectAnnotationsTask;
import core.annotations.services.processor.tasks.IsAnnotationRegisteredTask;
import core.annotations.services.registry.AnnotationsRegistry;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask;
    private ApplyAnnotationToMethodTask applyAnnotationToMethodTask;
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask;
    private ReflectionService reflectionService;
    private IsAnnotationRegisteredTask isAnnotationRegisteredTask;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        this.gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
        this.extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
        this.reflectionService = new ReflectionServiceImpl();
        this.isAnnotationRegisteredTask = new IsAnnotationRegisteredTask();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return gatherAllObjectAnnotationsTask.run(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllAnnotationsFromObject(OrionObject);
        applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask(reflectionService, OrionObject);
        //we filter the annotations, because if it finds a registered annotation that matches
        //the one it is processing now then process it otherwise it means that we are
        //processing an annotation that has not been registered in which case we ignore it.
        //It could be a Java/Spring/etc. annotation in which case it is processed by the respective framework
        AnnotationsRegistry.filterAnnotations((annotation) -> isAnnotationRegisteredTask.run(allObjectAnnotationsList, (OrionAnnotation)annotation))
            .forEach((annotation) -> applyAnnotationToMethodTask.run((OrionAnnotation)annotation));
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}