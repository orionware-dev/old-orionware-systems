package datastructures.services.lists.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionConcurrentArrayList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask;

public class ListFactoryServiceImpl<T> extends DataStructuresObject implements ListFactoryService<T>
{
    private CreateEmptyArrayListTask<T> createEmptyArrayListTask;
    private CreateEmptyConcurrentArrayListTask<T> createEmptyConcurrentArrayListTask;
    
    
    public ListFactoryServiceImpl()
    {
        
    }
    
    
    public OrionList<T> createEmptyArrayList()
    {
        return createEmptyArrayListTask.run();
    }

    
    @Override
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList()
    {
        return createEmptyConcurrentArrayListTask.run();
    }


    @Injector(ID = "datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask")
    private void setCreateEmptyArrayListTask(CreateEmptyArrayListTask<T> createEmptyArrayListTask)
    {
        this.createEmptyArrayListTask = createEmptyArrayListTask;
    }
    
    
    @Injector(ID = "datastructures.services.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask")
    private void setCreateEmptyConcurrentArrayListTask(CreateEmptyConcurrentArrayListTask<T> createEmptyConcurrentArrayListTask)
    {
        this.createEmptyConcurrentArrayListTask = createEmptyConcurrentArrayListTask;
    }
}