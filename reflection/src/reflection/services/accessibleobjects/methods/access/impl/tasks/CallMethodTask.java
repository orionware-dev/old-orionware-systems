package reflection.services.accessibleobjects.methods.access.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class CallMethodTask extends ReflectionObject implements ReflectionTask
{
    public Object run(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        try
        {
            if(methodArguments.length == 0)
            {
                methodArguments = new Object[]{};
            }
            
            return method.invoke(objectMethodBelongsTo, methodArguments);
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }

        return Boolean.FALSE;
    }
}