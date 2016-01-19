package core.reflection.tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import core.services.OrionTask;

public class CallConstructorTask implements OrionTask
{
    public boolean run(Constructor<?> constructor, Object... methodArguments)
    {
        try
        {
            constructor.newInstance(methodArguments);
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
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        
        return false;
    }
}