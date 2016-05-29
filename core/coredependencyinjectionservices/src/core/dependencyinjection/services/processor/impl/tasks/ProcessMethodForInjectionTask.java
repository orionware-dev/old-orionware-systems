package core.dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.Injector;
import core.reflection.facades.loader.ReflectionFacade;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionFacade reflectionFacade;
    
    
    public void run(Object object, Method method, ReflectionFacade reflectionFacade, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        this.reflectionFacade = reflectionFacade;
        this.object = object;
        reflectionFacade.makeMethodAccessible(method);
        Injector injection = (Injector)annotationsGatheringFacade.extractAnnotationFromMethod(method, Injector.class);
        
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
            reflectionFacade.callMethod(method, object, Class.forName(classToInject).newInstance());
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