package reflection.services.loader.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        return Arrays.stream(aClass.getDeclaredMethods()).toArray(Method[]::new);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}