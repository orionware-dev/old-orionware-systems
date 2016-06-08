package core.objects.services.equality;

import java.util.Collection;
import core.services.OrionService;

public interface ObjectsEqualityService extends OrionService
{
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects);
}