package core.objects.services.equality.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import core.OrionSimpleObject;
import core.objects.services.equality.ObjectsEqualityService;

public class ObjectsEqualityServiceImpl extends OrionSimpleObject implements ObjectsEqualityService
{
    @Override
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
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