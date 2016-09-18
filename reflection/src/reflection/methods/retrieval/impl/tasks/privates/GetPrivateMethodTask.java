package reflection.methods.retrieval.impl.tasks.privates;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.methods.retrieval.impl.tasks.checks.IsPrivateMethodTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredMethodTask;

public class GetPrivateMethodTask extends ReflectionObject implements ReflectionTask
{
    public static Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        Method method = GetDeclaredMethodTask.run(methodName, aClass, methodParameterTypes);

        if(IsPrivateMethodTask.run(method))
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