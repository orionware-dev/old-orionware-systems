package reflection.services.accessibleobjects.methods.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetMethodTask extends ReflectionObject implements ReflectionTask
{
    public Method run(Object object, String methodName)
    {
        return run(methodName, object.getClass(), Object.class);
    }
    
    
    public Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        try
        {
            if(methodParameterTypes.length == 0)
            {
                methodParameterTypes = new Class<?>[]{};
            }
            
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