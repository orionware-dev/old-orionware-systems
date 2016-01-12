package core.reflection.tasks;

import java.lang.reflect.InvocationTargetException;
import core.services.OrionTask;

public class InstantiateClassTask extends OrionTask
{
    public Object run(Class<?> classToInstantiate)
    {
        try
        {
            return classToInstantiate.getConstructor().newInstance();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
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
}