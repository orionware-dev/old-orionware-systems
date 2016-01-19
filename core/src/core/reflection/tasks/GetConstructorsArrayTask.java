package core.reflection.tasks;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import core.OrionObject;
import core.services.OrionTask;

public class GetConstructorsArrayTask implements OrionTask
{
    public Constructor<?>[] run(OrionObject object)
    {
        return Arrays.stream(object.getClass().getDeclaredConstructors())
                    .filter((constructor) -> constructor != null).toArray(Constructor[]::new);
    }
}