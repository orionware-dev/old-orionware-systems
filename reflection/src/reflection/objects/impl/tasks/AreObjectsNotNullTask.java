package reflection.objects.impl.tasks;

import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNotNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            IsObjectNullTask isObjectNullTask = new IsObjectNullTask();
            long numberOfNotNullObjects = Arrays.stream(objects).filter(object -> isObjectNullTask.run(object)).count();

            if(numberOfNotNullObjects == 0)
            {
                return true;
            }
        }

        return false;
    }
}