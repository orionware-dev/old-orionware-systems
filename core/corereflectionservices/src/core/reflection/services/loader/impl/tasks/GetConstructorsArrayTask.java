package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Constructor<?>[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredConstructors())
                   .filter(constructor -> constructor != null).toArray(Constructor[]::new);
    }
}