package datastructures.services.sets.factory.impl.tasks;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArraySet;
import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;

public class CreateEmptyConcurrentHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionConcurrentSet<T> run()
    {
        return new OrionConcurrentSet<T>();
    }
}