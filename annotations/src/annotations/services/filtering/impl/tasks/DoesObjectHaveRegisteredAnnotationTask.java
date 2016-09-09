package annotations.services.filtering.impl.tasks;

import java.util.Collection;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;

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