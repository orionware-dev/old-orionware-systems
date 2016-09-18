package reflection.methods.retrieval.impl.tasks.declared;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Class<?> aClass)
    {
        return aClass.getDeclaredMethods();
    }
    
    
    public static Method[] run(Object object)
    {
        return run(object.getClass());
    }
}