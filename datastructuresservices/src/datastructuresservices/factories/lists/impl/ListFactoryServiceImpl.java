package datastructuresservices.factories.lists.impl;

import datastructures.lists.OrionList;
import datastructuresservices.DataStructureServiceObject;
import datastructuresservices.factories.lists.ListFactoryService;

public class ListFactoryServiceImpl<T> extends DataStructureServiceObject implements ListFactoryService<T>
{
    @Override
    public OrionList<T> getEmptyList(T listType)
    {
        return null;
    }
}