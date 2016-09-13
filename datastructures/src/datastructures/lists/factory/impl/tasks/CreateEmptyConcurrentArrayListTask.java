package datastructures.lists.factory.impl.tasks;

import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;
import datastructures.lists.impl.OrionConcurrentArrayList;

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