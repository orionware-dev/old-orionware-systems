package core.reflection.services.equality.impl;

import core.OrionSimpleObject;
import core.reflection.services.equality.ObjectsEqualityService;
import core.reflection.services.equality.impl.tasks.AreObjectsEqualTask;

public class ObjectsEqualityServiceImpl extends OrionSimpleObject implements ObjectsEqualityService
{
    @Override
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return AreObjectsEqualTask.run(object1, object2, moreObjects);
    }
}