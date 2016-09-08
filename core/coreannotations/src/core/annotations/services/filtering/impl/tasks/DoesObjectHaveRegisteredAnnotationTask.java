package core.annotations.services.filtering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.Collection;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class DoesObjectHaveRegisteredAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(Collection<Annotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        return allObjectAnnotations.stream().filter(annotation -> {
            String annotationName = annotation.annotationType().getName();
            return annotationName.equals(registeredAnnotation.getAnnotationClass());
        }).count() >= 1;
    }
}