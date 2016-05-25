package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class DoesObjectHaveRegisteredAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(List<Annotation> allObjectAnnotationsList, OrionAnnotation registeredAnnotation)
    {
        return allObjectAnnotationsList.stream()
                   .filter((annotation) -> 
                       {
                           String annotationName = annotation.annotationType().getName();
                           return annotationName.equals(registeredAnnotation.getAnnotationClass());
                       }).count() == 1;
    }
}