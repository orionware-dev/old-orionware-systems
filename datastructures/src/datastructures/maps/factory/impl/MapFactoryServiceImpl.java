package datastructures.maps.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.maps.OrionMap;
import datastructures.maps.factory.MapFactoryService;
import datastructures.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask;
import datastructures.maps.factory.impl.tasks.CreateEmptyHashMapTask;
import datastructures.maps.impl.OrionConcurrentHashMap;
import dependencyinjection.annotation.Injector;

public class MapFactoryServiceImpl<T, T1, T2> extends DataStructuresObject implements MapFactoryService<T, T1, T2>
{
    @Injector
    private CreateEmptyHashMapTask<T, T1, T2> createEmptyHashMapTask;
    @Injector
    private CreateEmptyConcurrentHashMapTask<T, T1, T2> createEmptyConcurrentHashMapTask;
    
    
    public OrionMap<T, T1, T2> createEmptyHashMap()
    {
        return createEmptyHashMapTask.run();
    }


    @Override
    public OrionConcurrentHashMap<T, T1, T2> createEmptyConcurrentHashMap()
    {
        return createEmptyConcurrentHashMapTask.run();
    }
}