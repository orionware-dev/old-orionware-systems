package datastructures.services.lists.factory.impl.tasks;

import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionConcurrentArrayList;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyConcurrentArrayListTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionConcurrentArrayList<T> run()
    {
        return new OrionConcurrentArrayList<T>();
    }
}