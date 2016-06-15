package datastructures.services.sets.factory.impl.tasks;

import java.util.Collections;
import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionSet;

public class CreateEmptyConcurrentHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionSet<T> run()
    {
        return (OrionSet<T>)Collections.synchronizedSet(new CreateEmptyHashSetTask<T>().run());
    }
}