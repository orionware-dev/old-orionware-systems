package datastructures.sets.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.sets.OrionSet;
import datastructures.sets.factory.SetFactoryService;
import datastructures.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.impl.OrionConcurrentSet;

public class SetFactoryServiceImpl<T> extends DataStructuresObject implements SetFactoryService<T>
{
    @Override
    public OrionSet<T> createEmptyHashSet()
    {
        return new CreateEmptyHashSetTask<T>().run();
    }


    @Override
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet()
    {
        return new CreateEmptyConcurrentHashSetTask<T>().run();
    }
}