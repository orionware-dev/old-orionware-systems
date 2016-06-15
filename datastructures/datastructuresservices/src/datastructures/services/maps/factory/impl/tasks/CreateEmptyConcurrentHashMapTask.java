package datastructures.services.maps.factory.impl.tasks;

import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyConcurrentHashMapTask<T, T1, T2> extends DataStructuresServicesObject implements DataStructuresTask
{
    @SuppressWarnings("unchecked")
    public OrionMap<T, T1, T2> run()
    {
        return (OrionMap<T, T1, T2>)Collections.synchronizedMap(new CreateEmptyHashMapTask<T, T1, T2>().run());
    }
}