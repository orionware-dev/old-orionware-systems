package reflection.services.equality.impl;

import core.OrionSimpleObject;
import reflection.services.equality.ObjectsEqualityService;
import reflection.services.equality.impl.tasks.AreObjectsEqualTask;

public class ObjectsEqualityServiceImpl extends OrionSimpleObject implements ObjectsEqualityService
{
    @Override
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return new AreObjectsEqualTask().run(object1, object2, moreObjects);
    }
}