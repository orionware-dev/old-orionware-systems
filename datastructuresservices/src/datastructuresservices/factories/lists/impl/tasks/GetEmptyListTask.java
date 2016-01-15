package datastructuresservices.factories.lists.impl.tasks;

import core.services.OrionTask;
import datastructures.lists.OrionArrayList;

public class GetEmptyListTask<T> implements OrionTask
{
    public Object run(T listType)
    {
        return new OrionArrayList<T>();
    }
}