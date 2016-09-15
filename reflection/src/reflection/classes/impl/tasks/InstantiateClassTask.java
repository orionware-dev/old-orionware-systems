package reflection.classes.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class InstantiateClassTask extends ReflectionObject implements ReflectionTask
{
    public static Object run(Class<?> classToInstantiate, Class<?>... constructorArguments)
    {
        try
        {
            return classToInstantiate.getConstructor(constructorArguments).newInstance();
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