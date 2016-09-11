package reflection.services.accessibleobjects.constructors.retrieval.impl.tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPublicConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Constructor<?>[] run(Class<?> aClass)
    {
        return aClass.getConstructors();
    }
    
    
    public Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}