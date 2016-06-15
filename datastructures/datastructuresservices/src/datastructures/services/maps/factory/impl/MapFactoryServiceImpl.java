package datastructures.services.maps.factory.impl;

import core.dependencyinjection.Injector;
import datastructures.maps.OrionConcurrentHashMap;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask;
import datastructures.services.maps.factory.impl.tasks.CreateEmptyHashMapTask;

public class MapFactoryServiceImpl<T, T1, T2> extends DataStructuresServicesObject implements MapFactoryService<T, T1, T2>
{
    private CreateEmptyHashMapTask<T, T1, T2> createEmptyHashMapTask;
    private CreateEmptyConcurrentHashMapTask<T, T1, T2> createEmptyConcurrentHashMapTask;
    
    
    public MapFactoryServiceImpl()
    {
        
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


    @Injector(ID = "datastructures.services.maps.factory.impl.tasks.CreateEmptyHashMapTask")
    private void setCreateEmptyHashMapTask(CreateEmptyHashMapTask<T, T1, T2> createEmptyHashMapTask)
    {
        this.createEmptyHashMapTask = createEmptyHashMapTask;
    }


    @Injector(ID = "datastructures.services.maps.factory.impl.tasks.CreateEmptyConcurrentHashMapTask")
    private void setCreateEmptyConcurrentHashMapTask(CreateEmptyConcurrentHashMapTask<T, T1, T2> createEmptyConcurrentHashMapTask)
    {
        this.createEmptyConcurrentHashMapTask = createEmptyConcurrentHashMapTask;
    }
}