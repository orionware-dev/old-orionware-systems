package datastructures.services.maps.factory.impl.tasks;

import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;
import datastructures.maps.impl.OrionConcurrentHashMap;

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