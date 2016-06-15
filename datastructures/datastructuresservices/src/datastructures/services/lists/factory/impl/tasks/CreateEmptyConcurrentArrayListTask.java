package datastructures.services.lists.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionConcurrentArrayList;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyConcurrentArrayListTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionConcurrentArrayList<T> run()
    {
        return new OrionConcurrentArrayList<T>();
    }
}