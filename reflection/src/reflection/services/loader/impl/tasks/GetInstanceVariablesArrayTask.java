package reflection.services.loader.impl.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Object object)
    {
        return Arrays.stream(object.getClass().getDeclaredFields()).toArray(Field[]::new);
    }
}