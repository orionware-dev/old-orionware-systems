package annotations.registry.impl.tasks;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;

public class AddAnnotationTypeForObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(OrionAnnotation annotation, AnnotationType annotationType)
    {
        annotation.addAnnotationType(annotationType);
    }
}