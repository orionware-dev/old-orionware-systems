package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Field;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.InjectorImpl;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessInstanceVariableForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ReflectionLoaderService reflectionLoaderService;


    public ProcessInstanceVariableForInjectionImplTask()
    {
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
    }


    public void run(Object object, Field instanceVariable)
    {
        reflectionLoaderService.makeInstanceVariableAccessible(instanceVariable);
        AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        InjectorImpl injection = (InjectorImpl)annotationsGatheringService.extractAnnotationFromInstanceVariable(instanceVariable, InjectorImpl.class);
        
        if(injection != null)
        {
            processInjection(object, instanceVariable, injection);
        }
    }


    private void processInjection(Object object, Field instanceVariable, InjectorImpl injection)
    {
        String classToInjectString = instanceVariable.getType().getName();
        String className = classToInjectString.substring(classToInjectString.lastIndexOf(".") + 1);
        classToInjectString = classToInjectString.substring(0, classToInjectString.lastIndexOf("."));
        classToInjectString += ".impl." + className + "Impl";
        Class<?> classToInject = reflectionLoaderService.loadClass(classToInjectString);
        
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