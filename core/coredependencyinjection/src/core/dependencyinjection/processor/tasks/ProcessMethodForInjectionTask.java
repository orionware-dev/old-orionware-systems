package core.dependencyinjection.processor.tasks;

import java.lang.reflect.Method;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.Injector;
import core.reflection.loader.ReflectionService;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionService reflectionService;
    
    
    public void run(Object object, Method method, ReflectionService reflectionService, AnnotationsGatheringService annotationsGatheringService)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        reflectionService.makeMethodAccessible(method);
        Injector injection = (Injector)annotationsGatheringService.extractAnnotationFromMethod(method, Injector.class);
        
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