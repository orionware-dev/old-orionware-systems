package reflection.services.accessibleobjects.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsPublicMethodTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Method method)
    {
        return method != null && Modifier.isPublic(method.getModifiers());
    }
}