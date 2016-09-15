package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNullTask extends ReflectionObject implements ReflectionTask
{
    public static  boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            for(Object object : objects)
            {
                if(IsObjectNotNullTask.run(object))
                {
                    return false;
                }
            }
        }

        return true;
    }
}