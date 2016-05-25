package core.annotations.services.processor;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.AnnotationsGatheringServiceImpl;
import core.annotations.services.processor.tasks.ApplyAnnotationsToMethodTask;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private ApplyAnnotationsToMethodTask applyAnnotationsToMethodTask;
    private AnnotationsGatheringService annotationsGatheringService;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        this.applyAnnotationsToMethodTask = new ApplyAnnotationsToMethodTask();
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
        Stream<OrionAnnotation> registeredAnnotations = annotationsGatheringService.filterRegisteredAnnotationsStreamFromObjectAnnotations(allObjectAnnotationsList);
        applyAnnotationsToMethodTask.run(registeredAnnotations, OrionObject);
    }
}