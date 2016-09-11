package reflection.services.accessibleobjects.instancevariables.impl.tasks;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        return aClass.getDeclaredFields();
    }
    
    
    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}