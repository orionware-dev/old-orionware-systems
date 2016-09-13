package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredPublicMethodTask extends ReflectionObject implements ReflectionTask
{
    public Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        Method method = new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);

        if(new IsPublicMethodTask().run(method))
        {
            return method;
        }

        return null;
    }


    public Method run(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return run(methodName, object.getClass(), methodParameterTypes);
    }
}