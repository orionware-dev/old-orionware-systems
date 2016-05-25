package core.annotations.services.processor.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        ReflectionService reflectionService = new ReflectionServiceImpl();
        annotationsStream.forEach((annotation) -> applyAnnotationToMethodTask.run(reflectionService, OrionObject, (OrionAnnotation)annotation));
    }
}