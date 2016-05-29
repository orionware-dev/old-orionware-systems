package core.dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    
    
    public void run(Object object, Method method, ReflectionLoaderFacade reflectionLoaderFacade, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        this.reflectionLoaderFacade = reflectionLoaderFacade;
        this.object = object;
        reflectionLoaderFacade.makeMethodAccessible(method);
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
            reflectionLoaderFacade.callMethod(method, object, Class.forName(classToInject).newInstance());
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