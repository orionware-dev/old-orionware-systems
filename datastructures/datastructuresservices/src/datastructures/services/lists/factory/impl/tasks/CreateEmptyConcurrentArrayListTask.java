package datastructures.services.lists.factory.impl.tasks;

import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyConcurrentArrayListTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionList<T> run()
    {
        return (OrionList<T>)Collections.synchronizedList(new CreateEmptyArrayListTask<T>().run());
    }
}