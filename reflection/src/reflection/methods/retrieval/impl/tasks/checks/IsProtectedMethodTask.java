package reflection.methods.retrieval.impl.tasks.checks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsProtectedMethodTask extends ReflectionObject implements ReflectionTask
{
    public static boolean run(Method method)
    {
        return method != null && Modifier.isProtected(method.getModifiers());
    }
}