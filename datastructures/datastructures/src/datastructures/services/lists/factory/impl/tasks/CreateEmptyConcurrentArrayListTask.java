package datastructures.services.lists.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.impl.OrionConcurrentArrayList;
import datastructures.DataStructuresObject;

public class CreateEmptyConcurrentArrayListTask<T> extends DataStructuresObject implements DataStructuresTask
{
    public CreateEmptyConcurrentArrayListTask()
    {
        
    }
    
    
    public OrionConcurrentArrayList<T> run()
    {
        return new OrionConcurrentArrayList<T>();
    }
}