package datastructures.services.maps.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.maps.OrionMap;
import datastructures.maps.impl.OrionConcurrentHashMap;
import datastructures.DataStructuresObject;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyHashMapTask;

public class MapFactoryServiceImpl<T, T1, T2> extends DataStructuresObject implements MapFactoryService<T, T1, T2>
{
    private CreateEmptyHashMapTask<T, T1, T2> createEmptyHashMapTask;
    private CreateEmptyConcurrentHashMapTask<T, T1, T2> createEmptyConcurrentHashMapTask;
    
    
    public MapFactoryServiceImpl()
    {
        this.createEmptyHashMapTask = new CreateEmptyHashMapTask<T, T1, T2>();
        this.createEmptyConcurrentHashMapTask = new CreateEmptyConcurrentHashMapTask<T, T1, T2>();
    }
    
    
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