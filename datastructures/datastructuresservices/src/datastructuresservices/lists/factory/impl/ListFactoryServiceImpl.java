package datastructuresservices.lists.factory.impl;

import core.OrionSimpleObject;
import datastructures.lists.OrionList;
import datastructuresservices.lists.factory.ListFactoryService;
import datastructuresservices.lists.factory.impl.tasks.CreateEmptyListTask;

public class ListFactoryServiceImpl<T> extends OrionSimpleObject implements ListFactoryService<T>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionList<T> createEmptyList(Class<T> listType)
    {
        return new CreateEmptyListTask().run(listType);
    }
}