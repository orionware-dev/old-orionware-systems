package reflection.instancevariables.retrieval.impl.tasks.declared;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Field[] run(Class<?> aClass)
    {
        return aClass.getDeclaredFields();
    }
    
    
    public static Field[] run(Object object)
    {
        return run(object.getClass());
    }
}