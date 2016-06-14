package datastructures.services.maps.factory.impl.tasks;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.maps.OrionHashMap;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionHashSet;
import datastructures.sets.OrionSet;

public class CreateEmptyHashMapTask<T, T1, T2> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionMap<T, T1, T2> run()
    {
        return new OrionHashMap<T, T1, T2>();
    }
}