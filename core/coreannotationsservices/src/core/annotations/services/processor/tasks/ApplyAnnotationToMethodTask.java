package core.annotations.services.processor.tasks;

import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.loader.ReflectionService;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    private ReflectionService reflectionService;
    private Object object;
    
    
    public ApplyAnnotationToMethodTask(ReflectionService reflectionService, Object object)
    {
        this.reflectionService = reflectionService;
        this.object = object;
    }
    

    public void run(OrionAnnotation registeredAnnotation)
    {
        try
        {
            //instantiate annotation service
            Object someAnnotationService = reflectionService.loadAndInstantiateClass(registeredAnnotation.getAnnotationService());
            //call annotation service method that will process this annotation
            Method someMethod = someAnnotationService.getClass().getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), Object.class);
            reflectionService.callMethod(someMethod, someAnnotationService, object);
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
    }
}