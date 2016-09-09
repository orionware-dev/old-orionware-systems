package annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation)
    {
        ReflectionLoaderService reflectionLoaderService = new ReflectionLoaderServiceImpl();
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = reflectionLoaderService.instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = reflectionLoaderService.getMethod(someAnnotationService, registeredAnnotation.getAnnotationServiceMethodToCall());
        reflectionLoaderService.callMethod(someMethod, someAnnotationService, object);
    }
}