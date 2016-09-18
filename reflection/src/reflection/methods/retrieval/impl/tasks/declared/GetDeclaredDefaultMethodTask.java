package reflection.methods.retrieval.impl.tasks.declared;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.methods.retrieval.impl.tasks.checks.IsDefaultMethodTask;

public class GetDeclaredDefaultMethodTask extends ReflectionObject implements ReflectionTask
{
    public static Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        Method method = GetDeclaredMethodTask.run(methodName, aClass, methodParameterTypes);

        if(IsDefaultMethodTask.run(method))
        {
            return method;
        }

        return null;
    }


    public static Method run(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return run(methodName, object.getClass(), methodParameterTypes);
    }
}