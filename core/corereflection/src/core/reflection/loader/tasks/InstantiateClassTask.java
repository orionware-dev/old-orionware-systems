package core.reflection.loader.tasks;

import java.lang.reflect.InvocationTargetException;
import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class InstantiateClassTask extends OrionSimpleObject implements OrionReflectionTask
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