package annotations.processing.impl;

import annotations.AnnotationServiceObject;
import annotations.processing.AnnotationsProcessorService;
import annotations.processing.impl.tasks.ProcessAllAnnotationsTask;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    @Override
    public void processAllAnnotations(Object object)
    {
        ProcessAllAnnotationsTask.run(object);
    }
}