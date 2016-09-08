package datastructures.services.sets.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructuresObject;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionConcurrentSet;

public class SetFactoryServiceImpl<T> extends DataStructuresObject implements SetFactoryService<T>
{
    private CreateEmptyHashSetTask<T> createEmptyHashSetTask;
    private CreateEmptyConcurrentHashSetTask<T> createEmptyConcurrentHashSetTask;
    
    
    public SetFactoryServiceImpl()
    {
        this.createEmptyHashSetTask = new CreateEmptyHashSetTask<T>();
        this.createEmptyConcurrentHashSetTask = new CreateEmptyConcurrentHashSetTask<T>();
    }
    
    
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