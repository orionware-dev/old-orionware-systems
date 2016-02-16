package core.reflection.loader.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class GetMethodsArrayTask extends OrionSimpleObject implements OrionReflectionTask
{
    public Method[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredMethods())
                    .filter((method) -> method != null).toArray(Method[]::new);
    }
}