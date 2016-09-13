package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredMethodTask extends ReflectionObject implements ReflectionTask
{
    public Method run(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    public Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        try
        {
            if(methodParameterTypes.length == 0)
            {
                methodParameterTypes = new Class<?>[]{Object.class};
            }
            
            return aClass.getDeclaredMethod(methodName, methodParameterTypes);
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