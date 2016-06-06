package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.consumers.Consumer3;
import core.functions.Function1x1;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation, Function1x1<String, Object> loadAndInstantiateClassMethod, Consumer3<Method, Object, Object> callMethodMethod)
    {
        //instantiate annotation service
        Object someAnnotationService = loadAndInstantiateClassMethod.run(registeredAnnotation.getAnnotationService());
        
        try
        {
            //call annotation service method that will process this annotation
            Method someMethod = someAnnotationService.getClass()
                                    .getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), Object.class);
            callMethodMethod.run(someMethod, someAnnotationService, object);
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