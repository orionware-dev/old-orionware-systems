package reflection.objects.impl.tasks;

import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            IsObjectNotNullTask isObjectNotNullTask = new IsObjectNotNullTask();
            long numberOfNullObjects = Arrays.stream(objects).filter(object -> isObjectNotNullTask.run(object)).count();

            if(numberOfNullObjects == 0)
            {
                return true;
            }
        }

        return false;
    }
}