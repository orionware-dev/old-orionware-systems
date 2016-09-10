package annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import reflection.services.accessibleobjects.classes.impl.ReflectionClassesServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ApplyAnnotationToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation)
    {
        ReflectionMethodsService reflectionMethodsService = new ReflectionMethodsServiceImpl();
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = new ReflectionClassesServiceImpl().instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = reflectionMethodsService.getMethod(someAnnotationService, registeredAnnotation.getAnnotationServiceMethodToCall());
        reflectionMethodsService.callMethod(someMethod, someAnnotationService, object);
    }
}