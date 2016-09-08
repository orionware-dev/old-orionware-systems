package datastructures.services.maps.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.maps.impl.OrionConcurrentHashMap;
import datastructures.DataStructuresObject;

public class CreateEmptyConcurrentHashMapTask<T, T1, T2> extends DataStructuresObject implements DataStructuresTask
{
    public CreateEmptyConcurrentHashMapTask()
    {
        
    }
    
    
    public OrionConcurrentHashMap<T, T1, T2> run()
    {
        return new OrionConcurrentHashMap<T, T1, T2>();
    }
}