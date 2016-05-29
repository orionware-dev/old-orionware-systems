package core.annotations.services.processor.impl.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.facades.loader.ReflectionFacade;
import core.reflection.facades.loader.impl.ReflectionFacadeImpl;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        ReflectionFacade reflectionFacade = new ReflectionFacadeImpl();
        annotationsStream.forEach((annotation) -> applyAnnotationToMethodTask.run(reflectionFacade, OrionObject, (OrionAnnotation)annotation));
    }
}