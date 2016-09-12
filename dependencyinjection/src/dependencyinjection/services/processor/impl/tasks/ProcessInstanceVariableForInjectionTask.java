package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Field;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.Injector;
import reflection.services.accessibleobjects.classes.ReflectionClassesService;
import reflection.services.accessibleobjects.classes.impl.ReflectionClassesServiceImpl;
import reflection.services.accessibleobjects.instancevariables.access.impl.ReflectionInstanceVariablesAccessServiceImpl;

public class ProcessInstanceVariableForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ReflectionClassesService reflectionClassesService;


    public ProcessInstanceVariableForInjectionTask()
    {
        this.reflectionClassesService = new ReflectionClassesServiceImpl();
    }


    public void run(Object object, Field instanceVariable)
    {
        new ReflectionInstanceVariablesAccessServiceImpl().makeInstanceVariableAccessible(instanceVariable);
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
            classToInject = reflectionClassesService.loadClass(instanceVariable.getType().getName());
        }
        else
        {
            classToInject = reflectionClassesService.loadClass(classToInjectString);
        }

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