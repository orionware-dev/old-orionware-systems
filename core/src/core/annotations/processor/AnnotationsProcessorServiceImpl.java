package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.extractor.ExtractAnnotationFromMethodCoordinator;
import core.annotations.processor.gatherer.GatherAllAnnotationsCoordinator;
import core.annotations.processor.process.ProcessAllAnnotationsCoordinator;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllAnnotationsCoordinator gatherAllAnnotationsCoordinator = new GatherAllAnnotationsCoordinator();
    private ProcessAllAnnotationsCoordinator processAllAnnotationsCoordinator = new ProcessAllAnnotationsCoordinator();
    private ExtractAnnotationFromMethodCoordinator extractAnnotationFromMethodCoordinator = new ExtractAnnotationFromMethodCoordinator();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(OrionObject OrionObject)
    {
        return gatherAllAnnotationsCoordinator.run(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        processAllAnnotationsCoordinator.run(this, reflectionService, OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodCoordinator.run(method, annotationClassToExtract);
    }
}