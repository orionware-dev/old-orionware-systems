package annotations.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.methods.retrieval.ReflectionMethodRetrievalService;
import reflection.methods.retrieval.impl.ReflectionMethodRetrievalServiceImpl;

public class ApplyAnnotationToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private static ReflectionClassesService reflectionClassesService = new ReflectionClassesServiceImpl();
    private static ReflectionMethodRetrievalService reflectionMethodRetrievalService = new ReflectionMethodRetrievalServiceImpl();
    private static ReflectionMethodAccessService reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
    
    
    public static void run(Object object, OrionAnnotation registeredAnnotation)
    {
        //instantiate annotation service that can process this specific annotation
        Object someAnnotationService = reflectionClassesService.instantiateClass(registeredAnnotation.getAnnotationService());
        //call annotation service method that will process this annotation
        Method someMethod = reflectionMethodRetrievalService.getDeclaredMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), someAnnotationService);
        reflectionMethodAccessService.callMethod(someMethod, someAnnotationService, object);
    }
}