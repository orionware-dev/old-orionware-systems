package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsDefaultMethodTask extends ReflectionObject implements ReflectionTask
{
    public static boolean run(Method method)
    {
        return method != null && !Modifier.isPrivate(method.getModifiers())
                        && !Modifier.isProtected(method.getModifiers())
                        && !Modifier.isPublic(method.getModifiers());
    }
}