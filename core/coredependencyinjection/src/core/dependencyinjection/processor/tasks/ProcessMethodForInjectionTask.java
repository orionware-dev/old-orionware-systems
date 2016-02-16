package core.dependencyinjection.processor.tasks;

import java.lang.reflect.Method;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.Injector;
import core.reflection.loader.ReflectionService;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionService reflectionService;
    
    
    public void run(Object object, Method method, ReflectionService reflectionService, AnnotationsProcessorService annotationsProcessorService)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        reflectionService.makeMethodAccessible(method);
        Injector injection = (Injector)annotationsProcessorService.extractAnnotationFromMethod(method, Injector.class);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }
    
    
    private void processInjection(Method method, Injector injection)
    {
        String classToInject = injection.ID();
        
        try
        {
            reflectionService.callMethod(method, object, Class.forName(classToInject).newInstance());
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
}