package annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import reflection.services.accessibleobjects.classes.impl.ReflectionClassesServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ApplyAnnotationToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation)
    {
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = new ReflectionClassesServiceImpl().instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = new ReflectionMethodsServiceImpl().getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), someAnnotationService);
        new ReflectionMethodAccessServiceImpl().callMethod(someMethod, someAnnotationService, object);
    }
}