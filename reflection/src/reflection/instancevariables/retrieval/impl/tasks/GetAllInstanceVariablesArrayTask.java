package reflection.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAllInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        List<Field> inherittedInstanceVariables = Arrays.asList(new GetInherittedInstanceVariablesArrayTask().run(aClass));
        List<Field> declaredInstanceVariables = Arrays.asList(new GetDeclaredInstanceVariablesArrayTask().run(aClass));
        declaredInstanceVariables.addAll(inherittedInstanceVariables);
        return declaredInstanceVariables.toArray(new Field[0]);
    }


    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}