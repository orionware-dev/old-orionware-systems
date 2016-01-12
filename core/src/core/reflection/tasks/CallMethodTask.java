package core.reflection.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.services.OrionTask;

public class CallMethodTask implements OrionTask
{
    private Method method;
    private Object objectMethodBelongsTo;
    private Object[] methodArguments;
    
    
    public CallMethodTask(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        this.method = method;
        this.objectMethodBelongsTo = objectMethodBelongsTo;
        this.methodArguments = methodArguments;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        try
        {
            method.invoke(objectMethodBelongsTo, methodArguments);
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
        
        return null;
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}