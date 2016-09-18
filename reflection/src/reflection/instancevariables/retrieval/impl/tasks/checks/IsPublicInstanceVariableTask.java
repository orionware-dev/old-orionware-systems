package reflection.instancevariables.retrieval.impl.tasks.checks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsPublicInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public static boolean run(Field instanceVariable)
    {
        return instanceVariable != null && Modifier.isPublic(instanceVariable.getModifiers());
    }
}