package datastructures.sets.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.sets.OrionSet;
import datastructures.sets.factory.SetFactoryService;
import datastructures.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.impl.OrionConcurrentSet;
import dependencyinjection.annotation.Injector;

public class SetFactoryServiceImpl<T> extends DataStructuresObject implements SetFactoryService<T>
{
    @Injector
    private CreateEmptyHashSetTask<T> createEmptyHashSetTask;
    @Injector
    private CreateEmptyConcurrentHashSetTask<T> createEmptyConcurrentHashSetTask;
    
    
    @Override
    public OrionSet<T> createEmptyHashSet()
    {
        return createEmptyHashSetTask.run();
    }


    @Override
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet()
    {
        return createEmptyConcurrentHashSetTask.run();
    }
}