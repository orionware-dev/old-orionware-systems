package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation)
    {
        ReflectionLoaderFacade reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = reflectionLoaderFacade.instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = reflectionLoaderFacade.getMethod(someAnnotationService, registeredAnnotation.getAnnotationServiceMethodToCall());
        reflectionLoaderFacade.callMethod(someMethod, someAnnotationService, object);
    }
}