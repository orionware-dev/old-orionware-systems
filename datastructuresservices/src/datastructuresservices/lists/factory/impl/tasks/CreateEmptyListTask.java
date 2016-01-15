package datastructuresservices.lists.factory.impl.tasks;

import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresTask;

public class CreateEmptyListTask extends DataStructuresTask
{
    public OrionList<?> run()
    {
        return new OrionArrayList<>();
    }
}