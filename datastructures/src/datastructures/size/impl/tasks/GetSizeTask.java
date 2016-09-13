package datastructures.size.impl.tasks;

import datastructures.DataStructure;
import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;

public class GetSizeTask<T1, T2, T3> extends DataStructuresObject implements DataStructuresTask
{
    public int run(DataStructure dataStructure)
    {
        if(dataStructure != null)
        {
            return dataStructure.getSize();
        }
        
        return 0;
    }
}