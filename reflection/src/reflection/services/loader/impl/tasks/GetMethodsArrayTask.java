package reflection.services.loader.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredMethods()).toArray(Method[]::new);
    }
}