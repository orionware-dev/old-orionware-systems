package reflection.instancevariables.retrieval.impl.tasks.declared;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.instancevariables.retrieval.impl.tasks.checks.IsProtectedInstanceVariableTask;

public class GetDeclaredProtectedInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public static Field run(String instanceVariableName, Class<?> aClass)
    {
        Field field = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);

        if(IsProtectedInstanceVariableTask.run(field))
        {
            return field;
        }

        return null;
    }


    public static Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }
}