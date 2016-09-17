package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import configuration.registry.impl.ConfigurationPropertiesServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.annotation.Prop;

public class ProcessCustomInjectionForInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private InjectClassToInstanceVariableTask injectClassToInstanceVariableTask = new InjectClassToInstanceVariableTask();
    
    
    public void run(Object object, Injector injection, Field instanceVariable)
    {
        if(injection != null)
        {
            String classToInjectString = injection.ID();
            
            if(classToInjectString.isEmpty())
            {
                classToInjectString = instanceVariable.getType().getName();
            }
            
            injectClassToInstanceVariableTask.run(object, classToInjectString, instanceVariable);
        }
    }
}