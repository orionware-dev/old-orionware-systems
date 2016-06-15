package datastructures.services.maps.factory.impl;

import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyHashMapTask;

public class MapFactoryServiceImpl<T, T1, T2> extends DataStructuresServicesObject implements MapFactoryService<T, T1, T2>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionMap<T, T1, T2> createEmptyHashMap()
    {
        return new CreateEmptyHashMapTask().run();
    }

    
    @Override
    public OrionMap<T, T1, T2> createEmptyConcurrentHashMap()
    {
        return new CreateEmptyConcurrentHashMapTask<T, T1, T2>().run();
    }
}