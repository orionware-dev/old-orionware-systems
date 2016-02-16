package core.reflection.loader.tasks;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class GetConstructorsArrayTask extends OrionSimpleObject implements OrionReflectionTask
{
    public Constructor<?>[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredConstructors())
                    .filter((constructor) -> constructor != null).toArray(Constructor[]::new);
    }
}