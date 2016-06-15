package datastructures.services.sets.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionConcurrentSet;

public class CreateEmptyConcurrentHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionConcurrentSet<T> run()
    {
        return new OrionConcurrentSet<T>();
    }
}