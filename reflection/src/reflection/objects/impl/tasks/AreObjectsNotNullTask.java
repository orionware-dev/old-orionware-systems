package reflection.objects.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNotNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            IsObjectNullTask isObjectNullTask = new IsObjectNullTask();
            
            for(Object object : objects)
            {
                if(isObjectNullTask.run(object))
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