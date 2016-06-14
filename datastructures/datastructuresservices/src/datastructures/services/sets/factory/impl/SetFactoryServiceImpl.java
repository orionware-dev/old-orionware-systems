package datastructures.services.sets.factory.impl;

import core.OrionSimpleObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.OrionSet;

public class SetFactoryServiceImpl<T> extends OrionSimpleObject implements SetFactoryService<T>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionSet<T> createEmptyHashSet(Class<T> setType)
    {
        return new CreateEmptyHashSetTask().run(setType);
    }
}