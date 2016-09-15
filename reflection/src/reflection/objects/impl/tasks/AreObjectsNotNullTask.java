package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNotNullTask extends ReflectionObject implements ReflectionTask
{
    public static  boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            for(Object object : objects)
            {
                if(IsObjectNullTask.run(object))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }
}