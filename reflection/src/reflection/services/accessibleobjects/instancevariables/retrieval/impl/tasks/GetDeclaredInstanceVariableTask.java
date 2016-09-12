package reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }
    
    
    public Field run(String instanceVariableName, Class<?> aClass)
    {
        try
        {
            return aClass.getDeclaredField(instanceVariableName);
        }
        catch(NoSuchFieldException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return null;
    }
}