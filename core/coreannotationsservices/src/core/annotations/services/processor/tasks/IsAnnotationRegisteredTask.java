package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class IsAnnotationRegisteredTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(List<Annotation> allObjectAnnotationsList, OrionAnnotation registeredAnnotation)
    {
        return allObjectAnnotationsList.stream()
                    .filter((annotation) -> annotation.annotationType().getName().equals(registeredAnnotation.getAnnotationClass()))
                    .count() == 1;
    }
}