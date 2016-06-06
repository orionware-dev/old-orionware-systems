package core.annotations.services.processor.impl.tasks;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.functions.ConsumerWithThreeArguments;
import core.reflection.facades.loader.ReflectionLoaderFacade;

public class ApplyAnnotationToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Object object, OrionAnnotation registeredAnnotation, Function<String, Object> loadAndInstantiateClass, ConsumerWithThreeArguments<Method, Object, Object> callMethodMethod)
    {
        //instantiate annotation service
        Object someAnnotationService = loadAndInstantiateClass.apply(registeredAnnotation.getAnnotationService());
        
        try
        {
            //call annotation service method that will process this annotation
            Method someMethod = someAnnotationService.getClass()
                                    .getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), Object.class);
            callMethodMethod.accept(someMethod, someAnnotationService, object);
        }
        catch(NoSuchMethodException exception)
        {
            System.out.println("Method " + registeredAnnotation.getAnnotationServiceMethodToCall() + " does not exist");
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