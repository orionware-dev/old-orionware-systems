package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.InjectorImpl;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.instancevariables.access.impl.ReflectionInstanceVariablesAccessServiceImpl;

public class ProcessInstanceVariableForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ReflectionClassesService reflectionClassesService;


    public ProcessInstanceVariableForInjectionImplTask()
    {
        this.reflectionClassesService = new ReflectionClassesServiceImpl();
    }


    public void run(Object object, Field instanceVariable)
    {
        new ReflectionInstanceVariablesAccessServiceImpl().makeInstanceVariableAccessible(instanceVariable);
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
        Class<?> classToInject = reflectionClassesService.loadClass(classToInjectString);

        try
        {
            instanceVariable.set(object, reflectionClassesService.instantiateClass(classToInject));
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