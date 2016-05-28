package core.reflection.loader.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class CallMethodTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        try
        {
            method.invoke(objectMethodBelongsTo, methodArguments);
            return true;
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
        
        return false;
    }
}