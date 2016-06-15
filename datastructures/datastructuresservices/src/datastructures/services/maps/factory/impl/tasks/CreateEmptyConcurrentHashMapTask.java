package datastructures.services.maps.factory.impl.tasks;

import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.maps.OrionConcurrentHashMap;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyConcurrentHashMapTask<T, T1, T2> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionConcurrentHashMap<T, T1, T2> run()
    {
        return new OrionConcurrentHashMap<T, T1, T2>();
    }
}