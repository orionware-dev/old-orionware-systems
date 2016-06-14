package datastructures.services.lists.factory.impl;

import core.OrionSimpleObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyConcurrentArrayListTask;

public class ListFactoryServiceImpl<T> extends OrionSimpleObject implements ListFactoryService<T>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionList<T> createEmptyArrayList()
    {
        return new CreateEmptyArrayListTask().run();
    }

    
    @Override
    public OrionList<T> createEmptyConcurrentArrayList()
    {
        return new CreateEmptyConcurrentArrayListTask<T>().run();
    }
}