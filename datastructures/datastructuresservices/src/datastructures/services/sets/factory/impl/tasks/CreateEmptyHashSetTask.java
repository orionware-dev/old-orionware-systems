package datastructures.services.sets.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionHashSet;

public class CreateEmptyHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public CreateEmptyHashSetTask()
    {
        
    }
    
    
    public OrionSet<T> run()
    {
        return new OrionHashSet<T>();
    }
}