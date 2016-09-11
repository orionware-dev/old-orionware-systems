package reflection.services.accessibleobjects.methods.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAllMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        return Arrays.stream(aClass.getMethods()).toArray(Method[]::new);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}