package reflection.constructors.retrieval.impl.tasks;

import java.lang.reflect.Constructor;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Constructor<?>[] run(Class<?> aClass)
    {
        return aClass.getDeclaredConstructors();
    }
    
    
    public Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}