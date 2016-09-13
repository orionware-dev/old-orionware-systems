package datastructures.sets.factory.impl.tasks;

import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;
import datastructures.sets.impl.OrionConcurrentSet;

public class CreateEmptyConcurrentHashSetTask<T> extends DataStructuresObject implements DataStructuresTask
{
    public CreateEmptyConcurrentHashSetTask()
    {
        
    }
    
    
    public OrionConcurrentSet<T> run()
    {
        return new OrionConcurrentSet<T>();
    }
}