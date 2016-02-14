package datastructuresservices.lists.factory.impl.tasks;

import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresTask;

public class CreateEmptyListTask<T> extends DataStructuresTask
{
    public OrionList<T> run(Class<T> listType)
    {
        return new OrionArrayList<T>();
    }
}