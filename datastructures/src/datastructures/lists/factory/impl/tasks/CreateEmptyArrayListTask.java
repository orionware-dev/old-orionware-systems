package datastructures.lists.factory.impl.tasks;

import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;

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