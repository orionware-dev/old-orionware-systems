package reflection.services.accessibleobjects.instancevariables.impl.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        List<Field> allInstanceVariables = Arrays.asList(aClass.getFields());
        List<Field> declaredInstanceVariables = Arrays.asList(aClass.getDeclaredFields());
        //these are the inheritted instance variables only
        allInstanceVariables.removeAll(declaredInstanceVariables);
        return allInstanceVariables.toArray(new Field[0]);
    }
    
    
    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}