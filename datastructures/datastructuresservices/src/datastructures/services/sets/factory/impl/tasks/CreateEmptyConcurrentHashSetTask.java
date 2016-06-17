package datastructures.services.sets.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.impl.OrionConcurrentSet;

public class CreateEmptyConcurrentHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public CreateEmptyConcurrentHashSetTask()
    {
        
    }
    
    
    public OrionConcurrentSet<T> run()
    {
        return new OrionConcurrentSet<T>();
    }
}