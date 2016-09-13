package reflection.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPrivateInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public Field run(String instanceVariableName, Class<?> aClass)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);

        if(new IsPrivateInstanceVariableTask().run(field))
        {
            return field;
        }

        return null;
    }


    public Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }
}