package reflection.services.accessibleobjects.instancevariables.impl.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        return Arrays.stream(aClass.getDeclaredFields()).toArray(Field[]::new);
    }
    
    
    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}