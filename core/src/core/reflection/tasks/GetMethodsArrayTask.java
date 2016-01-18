package core.reflection.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionObject;
import core.services.OrionTask;

public class GetMethodsArrayTask implements OrionTask
{
    public Method[] run(OrionObject object)
    {
        return Arrays.stream(object.getClass().getDeclaredMethods())
                    .filter((method) -> method != null).toArray(Method[]::new);
    }
}