package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetMethodFromClassTask extends ReflectionObject implements ReflectionTask
{
    public Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        try
        {
            return aClass.getMethod(methodName, methodParameterTypes);
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}