package reflection.objects.equality.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.objects.ReflectionObjectsService;
import reflection.objects.impl.ReflectionObjectsServiceImpl;

public class AreObjectsEqualTask extends ReflectionObject implements ReflectionTask
{
    //we have object1 and object2 to make sure the user provides at least 2 objects to compare
    public boolean run(Object object1, Object object2, Object... moreObjects)
    {
        boolean areObjectsEqual = false;
        ReflectionObjectsService reflectionObjectsService = new ReflectionObjectsServiceImpl();

        if(reflectionObjectsService.areObjectsNotNull(object1, object2))
        {
            areObjectsEqual = object1.equals(object2);

            if(areObjectsEqual && moreObjects.length > 0)
            {
                for(Object object : moreObjects)
                {
                    //we use object1 to compare since we know by now that object1 = object2, so it doesn't matter which we use
                    areObjectsEqual = object1.equals(object);

                    if(!areObjectsEqual)
                    {
                        return false;
                    }
                }
            }
        }

        return areObjectsEqual;
    }
}