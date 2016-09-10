package reflection.services.accessibleobjects.constructors.impl.tasks;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Constructor<?>[] run(Class<?> aClass)
    {
        return Arrays.stream(aClass.getDeclaredConstructors()).filter(constructor -> constructor != null).toArray(Constructor[]::new);
    }
    
    
    public Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}