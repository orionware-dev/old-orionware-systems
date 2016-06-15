package datastructures.services.sets.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionHashSet;
import datastructures.sets.OrionSet;

public class CreateEmptyHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionSet<T> run()
    {
        return new OrionHashSet<T>();
    }
}