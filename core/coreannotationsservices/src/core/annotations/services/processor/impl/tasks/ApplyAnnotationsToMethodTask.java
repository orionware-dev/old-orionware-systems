package core.annotations.services.processor.impl.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        ReflectionLoaderFacade reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        annotationsStream.forEach((annotation) -> applyAnnotationToMethodTask.run(reflectionLoaderFacade, OrionObject, (OrionAnnotation)annotation));
    }
}