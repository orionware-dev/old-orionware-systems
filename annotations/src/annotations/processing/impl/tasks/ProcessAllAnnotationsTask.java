package annotations.processing.impl.tasks;

import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;

public class ProcessAllAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object)
    {
        List<OrionAnnotation> registeredAnnotationsForObject = new AnnotationsGatheringServiceImpl().gatherAllAnnotationsFromObject(object);
        new ApplyAnnotationsToObjectTask().run(registeredAnnotationsForObject, object);
    }
}