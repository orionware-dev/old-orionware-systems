package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class CallMethodTask extends ReflectionObject implements ReflectionTask
{
    public Object run(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        try
        {
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
    
    
    public Object run(String methodName, Object objectMethodBelongsTo, Object... methodArguments)
    {
        try
        {
            if(methodArguments.length == 1)
            {
                return run(objectMethodBelongsTo.getClass().getMethod(methodName, methodArguments[0].getClass()), objectMethodBelongsTo, methodArguments[0]);
            }
            else
            {
                return run(objectMethodBelongsTo.getClass().getMethod(methodName, methodArguments.getClass()), objectMethodBelongsTo, methodArguments);
            }
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return Boolean.FALSE;
    }
}