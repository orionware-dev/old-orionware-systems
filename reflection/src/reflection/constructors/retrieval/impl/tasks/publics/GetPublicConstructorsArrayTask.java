package reflection.constructors.retrieval.impl.tasks.publics;

import java.lang.reflect.Constructor;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPublicConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Constructor<?>[] run(Class<?> aClass)
    {
        return aClass.getConstructors();
    }
    
    
    public static Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}