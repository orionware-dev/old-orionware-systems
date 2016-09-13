package datastructures.sets.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.sets.OrionSet;
import datastructures.sets.factory.SetFactoryService;
import datastructures.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.sets.factory.impl.tasks.CreateEmptyHashSetTask;
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