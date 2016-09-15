package annotations.processing.impl;

import java.lang.annotation.Annotation;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.processing.AnnotationsProcessorService;
import annotations.processing.impl.tasks.ApplyMethodAnnotationTask;
import annotations.processing.impl.tasks.GetAnnotationNameTask;
import annotations.processing.impl.tasks.ProcessAllAnnotationsTask;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    @Override
    public void processAllAnnotations(Object object)
    {
        ProcessAllAnnotationsTask.run(object);
    }


    // returns true if annotation has been applied to method and false if it is
    // not registered
    @Override
    public boolean applyMethodAnnotation(Object object, OrionAnnotation annotationToProcess)
    {
        return new ApplyMethodAnnotationTask().run(object, annotationToProcess);
    }


    @Override
    public String getAnnotationName(Annotation annotation)
    {
        return GetAnnotationNameTask.run(annotation);
    }
}