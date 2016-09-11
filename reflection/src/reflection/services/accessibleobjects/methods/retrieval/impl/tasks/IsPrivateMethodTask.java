package reflection.services.accessibleobjects.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsPrivateMethodTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Method method)
    {
        return method != null && Modifier.isPrivate(method.getModifiers());
    }
}