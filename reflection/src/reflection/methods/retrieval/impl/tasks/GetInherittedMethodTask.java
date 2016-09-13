package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedMethodTask extends ReflectionObject implements ReflectionTask
{
    public Method run(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    public Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        Method inherittedMethod = null;
        
        try
        {
            if(methodParameterTypes.length == 0)
            {
                methodParameterTypes = new Class<?>[]{Object.class};
            }
            
            Method publicOrInherittedMethod = aClass.getMethod(methodName, methodParameterTypes);
            Method declaredMethod = new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
            
            if(declaredMethod == null || !Modifier.isPublic(declaredMethod.getModifiers()))
            {
                inherittedMethod = publicOrInherittedMethod;
            }
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return inherittedMethod;
    }
}