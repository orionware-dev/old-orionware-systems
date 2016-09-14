package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessCustomInjectionForInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Injector injection, Field instanceVariable)
    {
        if(injection != null)
        {
            String classToInjectString = injection.ID();
            
            if(classToInjectString.isEmpty())
            {
                classToInjectString = instanceVariable.getType().getName();
            }
            
            new InjectClassToInstanceVariableTask().run(object, classToInjectString, instanceVariable);
        }
    }
}