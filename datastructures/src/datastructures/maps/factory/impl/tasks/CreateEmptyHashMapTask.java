package datastructures.maps.factory.impl.tasks;

import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;
import datastructures.maps.OrionMap;
import datastructures.maps.impl.OrionHashMap;

public class CreateEmptyHashMapTask<T, T1, T2> extends DataStructuresObject implements DataStructuresTask
{
    public CreateEmptyHashMapTask()
    {
        
    }
    
    
    public OrionMap<T, T1, T2> run()
    {
        return new OrionHashMap<T, T1, T2>();
    }
}