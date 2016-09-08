package datastructures.services.lists.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;
import datastructures.DataStructuresObject;

public class CreateEmptyArrayListTask<T> extends DataStructuresObject implements DataStructuresTask
{
    public CreateEmptyArrayListTask()
    {
        
    }
    
    
    public OrionList<T> run()
    {
        return new OrionArrayList<T>();
    }
}