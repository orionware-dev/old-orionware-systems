package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.Injector;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessInstanceVariableForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ReflectionLoaderService reflectionLoaderService;


    public ProcessInstanceVariableForInjectionTask()
    {
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
    }


    public void run(Object object, Field instanceVariable)
    {
        reflectionLoaderService.makeInstanceVariableAccessible(instanceVariable);
        AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        Injector injection = (Injector)annotationsGatheringService.extractAnnotationFromInstanceVariable(instanceVariable, Injector.class);
        
        if(injection != null)
        {
            processInjection(object, instanceVariable, injection);
        }
    }


    private void processInjection(Object object, Field instanceVariable, Injector injection)
    {
        String classToInjectString = injection.ID();
        Class<?> classToInject = null;
        
        if(classToInjectString.isEmpty())
        {
            classToInject = reflectionLoaderService.loadClass(instanceVariable.getType().getName());
        }
        else
        {
            classToInject = reflectionLoaderService.loadClass(classToInjectString);
        }
        
        try
        {
            instanceVariable.set(object, reflectionLoaderService.instantiateClass(classToInject));
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }
}