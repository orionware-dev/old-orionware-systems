package datastructures.services.lists.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;

public class CreateEmptyListTask<T> implements DataStructuresTask
{
    public OrionList<T> run(Class<T> listType)
    {
        return new OrionArrayList<T>();
    }
}