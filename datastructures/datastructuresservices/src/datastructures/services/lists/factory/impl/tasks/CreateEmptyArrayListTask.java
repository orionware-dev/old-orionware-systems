package datastructures.services.lists.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;
import datastructures.services.DataStructuresServicesObject;

public class CreateEmptyArrayListTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public CreateEmptyArrayListTask()
    {
        
    }
    
    
    public OrionList<T> run()
    {
        return new OrionArrayList<T>();
    }
}