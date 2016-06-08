package core.reflection.facades.equality.impl;

import core.reflection.facades.ReflectionFacadeObject;
import core.reflection.facades.equality.ObjectsEqualityFacade;
import core.reflection.services.equality.impl.ObjectsEqualityServiceImpl;

public class ObjectsEqualityFacadeImpl extends ReflectionFacadeObject implements ObjectsEqualityFacade
{
    @Override
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return new ObjectsEqualityServiceImpl().areObjectsEqual(object1, object2, moreObjects);
    }
}