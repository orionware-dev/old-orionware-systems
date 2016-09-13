package reflection.objects.equality.impl;

import core.OrionSimpleObject;
import reflection.objects.equality.ObjectsEqualityService;
import reflection.objects.equality.impl.tasks.AreObjectsEqualTask;

public class ObjectsEqualityServiceImpl extends OrionSimpleObject implements ObjectsEqualityService
{
    @Override
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return new AreObjectsEqualTask().run(object1, object2, moreObjects);
    }
}