package datastructures.services.maps.factory.impl;

import core.OrionSimpleObject;
import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyHashMapTask;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.OrionSet;

public class MapFactoryServiceImpl<T, T1, T2> extends OrionSimpleObject implements MapFactoryService<T, T1, T2>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionMap<T, T1, T2> createEmptyHashMap()
    {
        return new CreateEmptyHashMapTask().run();
    }
}