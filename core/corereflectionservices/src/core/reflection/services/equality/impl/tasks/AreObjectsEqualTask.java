package core.reflection.services.equality.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class AreObjectsEqualTask extends ReflectionObject implements ReflectionTask
{
    public static boolean run(Object object1, Object object2, Object... moreObjects)
    {
        boolean areObjectsEqual = false;
        
        if(object1 != null && object2 != null)
        {
            areObjectsEqual = object1.equals(object2);
            
            if(areObjectsEqual && moreObjects.length > 0)
            {
                for(int i = 0; i < moreObjects.length; i++)
                {
                    areObjectsEqual = object1.equals(moreObjects[i]);
                    
                    if(!areObjectsEqual)
                    {
                        break;
                    }
                }
            }
        }
        
        return areObjectsEqual;
    }
}