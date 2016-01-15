package datastructuresservices.lists.factory.impl;

import datastructures.lists.OrionList;
import datastructuresservices.lists.factory.ListFactoryService;
import datastructuresservices.lists.factory.impl.tasks.CreateEmptyListTask;

public class ListFactoryServiceImpl implements ListFactoryService
{
    public OrionList<?> createEmptyList()
    {
        return new CreateEmptyListTask().run();
    }
}