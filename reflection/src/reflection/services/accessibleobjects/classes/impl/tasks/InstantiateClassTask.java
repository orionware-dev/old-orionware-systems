package reflection.services.accessibleobjects.classes.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class InstantiateClassTask extends ReflectionObject implements ReflectionTask
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