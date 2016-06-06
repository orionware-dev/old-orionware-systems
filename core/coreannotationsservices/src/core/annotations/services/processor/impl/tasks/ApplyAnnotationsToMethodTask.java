package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.functions.ConsumerWithThreeArguments;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject, Function<String, Object> loadAndInstantiateClass, ConsumerWithThreeArguments<Method, Object, Object> callMethodMethod)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        annotationsStream.forEach(annotation -> applyAnnotationToMethodTask.run(OrionObject, (OrionAnnotation)annotation, loadAndInstantiateClass, callMethodMethod));
    }
}