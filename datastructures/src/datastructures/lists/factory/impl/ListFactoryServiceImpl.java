package datastructures.lists.factory.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.factory.ListFactoryService;
import datastructures.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask;
import datastructures.lists.impl.OrionConcurrentArrayList;

public class ListFactoryServiceImpl<T> extends DataStructuresObject implements ListFactoryService<T>
{
    public OrionList<T> createEmptyArrayList()
    {
        return new CreateEmptyArrayListTask<T>().run();
    }


    @Override
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList()
    {
        return new CreateEmptyConcurrentArrayListTask<T>().run();
    }
}