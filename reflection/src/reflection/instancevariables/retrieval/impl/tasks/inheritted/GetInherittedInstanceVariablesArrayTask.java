package reflection.instancevariables.retrieval.impl.tasks.inheritted;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredPublicInstanceVariablesArrayTask;

public class GetInherittedInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Field[] run(Class<?> aClass)
    {
        List<Field> publicInstanceVariables = Arrays.asList(GetDeclaredPublicInstanceVariablesArrayTask.run(aClass));
        List<Field> publicAndInherittedInstanceVariables = Arrays.asList(aClass.getFields());
        // these are the inheritted instance variables only
        publicAndInherittedInstanceVariables.removeAll(publicInstanceVariables);
        return publicAndInherittedInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object)
    {
        return run(object.getClass());
    }
}