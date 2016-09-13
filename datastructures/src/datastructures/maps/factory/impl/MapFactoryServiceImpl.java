package datastructures.maps.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.maps.OrionMap;
import datastructures.maps.factory.MapFactoryService;
import datastructures.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask;
import datastructures.maps.factory.impl.tasks.CreateEmptyHashMapTask;
import datastructures.maps.impl.OrionConcurrentHashMap;

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