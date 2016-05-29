package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.reflection.facades.loader.ReflectionLoaderFacade;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(ReflectionLoaderFacade reflectionLoaderFacade, Object object, OrionAnnotation registeredAnnotation)
    {
        try
        {
            //instantiate annotation service
            Object someAnnotationService = reflectionLoaderFacade.loadAndInstantiateClass(registeredAnnotation.getAnnotationService());
            //call annotation service method that will process this annotation
            Method someMethod = someAnnotationService.getClass().getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), Object.class);
            reflectionLoaderFacade.callMethod(someMethod, someAnnotationService, object);
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