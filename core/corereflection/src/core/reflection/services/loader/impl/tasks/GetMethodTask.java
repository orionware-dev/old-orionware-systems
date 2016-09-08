package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetMethodTask extends ReflectionObject implements ReflectionTask
{
    public Method run(Object object, String methodName)
    {
        try
        {
            return object.getClass().getMethod(methodName, object.getClass());
        }
        catch(NoSuchMethodException exception)
        {
            System.out.println("Method " + methodName + " does not exist");
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}