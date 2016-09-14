package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.instancevariables.access.impl.ReflectionInstanceVariablesAccessServiceImpl;

public class InjectObjectToInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Object objectToInject, Field instanceVariable)
    {
        new ReflectionInstanceVariablesAccessServiceImpl().makeInstanceVariableAccessible(instanceVariable);

        try
        {
            instanceVariable.set(object, objectToInject);
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