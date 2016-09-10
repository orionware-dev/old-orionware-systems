package reflection.services.objects.impl.tasks;

import java.util.Arrays;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class AreObjectsNullTask extends ReflectionObject implements ReflectionTask
{
    public boolean run(Object... objects)
    {
        if(objects.length > 0)
        {
            long numberOfNullObjects = Arrays.stream(objects).filter(object -> object != null).count();
            
            if(numberOfNullObjects == 0)
            {
                return true;
            }
        }
        
        return false;
    }
}