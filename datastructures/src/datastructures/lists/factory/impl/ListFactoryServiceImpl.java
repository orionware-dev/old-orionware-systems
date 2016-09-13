package datastructures.lists.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.factory.ListFactoryService;
import datastructures.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask;
import datastructures.lists.impl.OrionConcurrentArrayList;

public class ListFactoryServiceImpl<T> extends DataStructuresObject implements ListFactoryService<T>
{
    private CreateEmptyArrayListTask<T> createEmptyArrayListTask;
    private CreateEmptyConcurrentArrayListTask<T> createEmptyConcurrentArrayListTask;
    
    
    public ListFactoryServiceImpl()
    {
        this.createEmptyArrayListTask = new CreateEmptyArrayListTask<T>();
        this.createEmptyConcurrentArrayListTask = new CreateEmptyConcurrentArrayListTask<T>();
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
}