package datastructures.lists.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.factory.ListFactoryService;
import datastructures.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask;
import datastructures.lists.impl.OrionConcurrentArrayList;
import dependencyinjection.annotation.Injector;

public class ListFactoryServiceImpl<T> extends DataStructuresObject implements ListFactoryService<T>
{
    @Injector
    private CreateEmptyArrayListTask<T> createEmptyArrayListTask;
    @Injector
    private CreateEmptyConcurrentArrayListTask<T> createEmptyConcurrentArrayListTask;
    
    
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