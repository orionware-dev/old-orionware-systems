package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistry;

public class GetRegisteredAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<OrionAnnotation> run(List<Annotation> allObjectAnnotationsList)
    {
        IsAnnotationRegisteredTask isAnnotationRegisteredTask = new IsAnnotationRegisteredTask();
        return AnnotationsRegistry.filterAnnotations((annotation) -> isAnnotationRegisteredTask.run(allObjectAnnotationsList, (OrionAnnotation)annotation));
    }
}