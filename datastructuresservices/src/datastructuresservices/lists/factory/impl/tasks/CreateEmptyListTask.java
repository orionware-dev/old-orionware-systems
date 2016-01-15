package datastructuresservices.lists.factory.impl.tasks;

import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.services.DataStructureTask;

public class CreateEmptyListTask extends DataStructureTask
{
    public OrionList<?> run()
    {
        return new OrionArrayList<>();
    }
}