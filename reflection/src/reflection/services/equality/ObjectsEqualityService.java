package reflection.services.equality;

import core.services.OrionService;

public interface ObjectsEqualityService extends OrionService
{
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects);
}