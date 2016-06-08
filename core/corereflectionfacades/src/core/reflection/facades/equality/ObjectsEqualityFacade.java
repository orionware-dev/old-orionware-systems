package core.reflection.facades.equality;

import core.reflection.ReflectionFacade;

public interface ObjectsEqualityFacade extends ReflectionFacade
{
    public boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects);
}