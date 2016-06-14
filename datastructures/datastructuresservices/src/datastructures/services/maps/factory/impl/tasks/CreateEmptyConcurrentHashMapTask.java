package datastructures.services.maps.factory.impl.tasks;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.maps.OrionHashMap;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.sets.OrionHashSet;
import datastructures.sets.OrionSet;

public class CreateEmptyConcurrentHashMapTask<T, T1, T2> extends DataStructuresServicesObject implements DataStructuresTask
{
    @SuppressWarnings("unchecked")
    public OrionMap<T, T1, T2> run()
    {
        return (OrionMap<T, T1, T2>)Collections.synchronizedMap(new CreateEmptyHashMapTask<T, T1, T2>().run());
    }
}