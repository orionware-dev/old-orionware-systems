package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.consumers.Consumer3;
import core.functions.Function1x1;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject, Function1x1<String, Object> loadAndInstantiateClass, Consumer3<Method, Object, Object> callMethodMethod)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        annotationsStream.forEach(annotation -> applyAnnotationToMethodTask.run(OrionObject, (OrionAnnotation)annotation, loadAndInstantiateClass, callMethodMethod));
    }
}