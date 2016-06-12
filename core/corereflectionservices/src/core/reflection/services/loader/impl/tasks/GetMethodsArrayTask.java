package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredMethods()).filter(method -> method != null).toArray(Method[]::new);
    }
}