package core.annotations.services.processor;

import java.lang.annotation.Annotation;
import java.util.List;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.AnnotationsGatheringServiceImpl;
import core.annotations.services.processor.tasks.ApplyAnnotationToMethodTask;
import core.annotations.services.processor.tasks.IsAnnotationRegisteredTask;
import core.annotations.services.registry.AnnotationsRegistry;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private ApplyAnnotationToMethodTask applyAnnotationToMethodTask;
    private ReflectionService reflectionService;
    private IsAnnotationRegisteredTask isAnnotationRegisteredTask;
    private AnnotationsGatheringService annotationsGatheringService;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        this.reflectionService = new ReflectionServiceImpl();
        this.isAnnotationRegisteredTask = new IsAnnotationRegisteredTask();
        this.applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = annotationsGatheringService.gatherAllAnnotationsFromObject(OrionObject);
        //we filter the annotations, because if it finds a registered annotation that matches
        //the one it is processing now then we can process it otherwise it means that we are
        //processing an annotation that has not been registered in which case we ignore it:
        //It could be a Java/Spring/etc. annotation in which case it is processed by the respective framework
        //getRegisteredAnnotationsTask();
        //applyAnnotationsToMethodTask();
        AnnotationsRegistry.filterAnnotations((annotation) -> isAnnotationRegisteredTask.run(allObjectAnnotationsList, (OrionAnnotation)annotation))
            .forEach((annotation) -> applyAnnotationToMethodTask.run(reflectionService, OrionObject, (OrionAnnotation)annotation));
    }
}