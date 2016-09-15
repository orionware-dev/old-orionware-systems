package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsObjectNotNullTask extends ReflectionObject implements ReflectionTask
{
    public static  boolean run(Object object)
    {
        return object != null;
    }
}