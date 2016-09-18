package reflection.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.inheritted.GetInherittedInstanceVariablesArrayTask;

public class GetAllInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Field[] run(Class<?> aClass)
    {
        List<Field> inherittedInstanceVariables = Arrays.asList(GetInherittedInstanceVariablesArrayTask.run(aClass));
        List<Field> declaredInstanceVariables = Arrays.asList(GetDeclaredInstanceVariablesArrayTask.run(aClass));
        declaredInstanceVariables.addAll(inherittedInstanceVariables);
        return declaredInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object)
    {
        return run(object.getClass());
    }
}