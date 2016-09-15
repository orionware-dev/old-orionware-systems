package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            IsObjectNotNullTask isObjectNotNullTask = new IsObjectNotNullTask();
            
            for(Object object : objects)
            {
                if(isObjectNotNullTask.run(object))
                {
                    return false;
                }
            }
        }

        return true;
    }
}