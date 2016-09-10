package reflection.services.equality.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.services.objects.ReflectionObjectsService;
import reflection.services.objects.impl.ReflectionObjectsServiceImpl;

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
                for(int i = 0; i < moreObjects.length; i++)
                {
                    areObjectsEqual = object1.equals(moreObjects[i]);

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