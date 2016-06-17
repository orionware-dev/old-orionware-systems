package datastructures.services.maps.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.maps.OrionMap;
import datastructures.maps.impl.OrionHashMap;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyHashMapTask<T, T1, T2> extends DataStructuresServicesObject implements DataStructuresTask
{
    public CreateEmptyHashMapTask()
    {
        
    }
    
    
    public OrionMap<T, T1, T2> run()
    {
        return new OrionHashMap<T, T1, T2>();
    }
}