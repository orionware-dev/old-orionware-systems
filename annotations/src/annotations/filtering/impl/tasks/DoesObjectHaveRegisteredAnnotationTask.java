package annotations.filtering.impl.tasks;

import java.util.Collection;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class DoesObjectHaveRegisteredAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        return allObjectAnnotations.stream().filter(annotation -> {
            String annotationName = annotation.getAnnotationClass();
            return annotationName.equals(registeredAnnotation.getAnnotationClass());
        }).count() > 0;
    }
}