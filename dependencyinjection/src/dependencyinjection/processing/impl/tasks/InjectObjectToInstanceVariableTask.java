package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.instancevariables.access.ReflectionInstanceVariablesAccessService;
import reflection.instancevariables.access.impl.ReflectionInstanceVariablesAccessServiceImpl;

public class InjectObjectToInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ReflectionInstanceVariablesAccessService reflectionInstanceVariablesAccessService = new ReflectionInstanceVariablesAccessServiceImpl();
    
    
    public void run(Object object, Object objectToInject, Field instanceVariable)
    {
        reflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);

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