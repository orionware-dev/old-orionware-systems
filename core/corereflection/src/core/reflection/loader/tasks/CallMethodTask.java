package core.reflection.loader.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class CallMethodTask extends OrionSimpleObject implements OrionReflectionTask
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