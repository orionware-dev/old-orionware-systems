package reflection.services.accessibleobjects.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        return aClass.getDeclaredMethods();
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}