package annotations.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodRetrievalServiceImpl;

public class ApplyAnnotationToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation)
    {
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = new ReflectionClassesServiceImpl().instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = new ReflectionMethodRetrievalServiceImpl().getDeclaredMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), someAnnotationService);
        new ReflectionMethodAccessServiceImpl().callMethod(someMethod, someAnnotationService, object);
    }
}