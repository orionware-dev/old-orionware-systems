package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class CallMethodTask extends ReflectionObject implements ReflectionTask
{
    public static Object run(Method method, Object objectMethodBelongsTo, Object... methodArguments)
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
}