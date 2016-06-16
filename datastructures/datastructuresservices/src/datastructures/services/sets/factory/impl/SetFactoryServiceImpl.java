package datastructures.services.sets.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;

public class SetFactoryServiceImpl<T> extends DataStructuresServicesObject implements SetFactoryService<T>
{
    private CreateEmptyHashSetTask<T> createEmptyHashSetTask;
    private CreateEmptyConcurrentHashSetTask<T> createEmptyConcurrentHashSetTask;
    
    
    public SetFactoryServiceImpl()
    {
        
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


    @Injector(ID = "datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask")
    private void setCreateEmptyHashSetTask(CreateEmptyHashSetTask<T> createEmptyHashSetTask)
    {
        this.createEmptyHashSetTask = createEmptyHashSetTask;
    }


    @Injector(ID = "datastructures.services.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask")
    private void setCreateEmptyConcurrentHashSetTask(CreateEmptyConcurrentHashSetTask<T> createEmptyConcurrentHashSetTask)
    {
        this.createEmptyConcurrentHashSetTask = createEmptyConcurrentHashSetTask;
    }
}