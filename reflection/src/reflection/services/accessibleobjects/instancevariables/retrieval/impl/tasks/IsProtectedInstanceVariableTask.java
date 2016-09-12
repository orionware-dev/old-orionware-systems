package reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsProtectedInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Field instanceVariable)
    {
        return instanceVariable != null && Modifier.isProtected(instanceVariable.getModifiers());
    }
}