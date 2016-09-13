package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class IsObjectNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object object)
    {
        return object == null;
    }
}