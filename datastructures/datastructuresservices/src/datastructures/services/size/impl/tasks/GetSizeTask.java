package datastructures.services.size.impl.tasks;

import datastructures.DataStructure;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionSet;

public class GetSizeTask<T1, T2, T3> extends DataStructuresServicesObject implements DataStructuresTask
{
    @SuppressWarnings("unchecked")
    public int run(DataStructure dataStructure)
    {
        if(dataStructure instanceof OrionList)
        {
            return getListSize((OrionList<T1>)dataStructure);
        }
        else if(dataStructure instanceof OrionSet)
        {
            return getSetSize((OrionSet<T1>)dataStructure);
        }
        else if(dataStructure instanceof OrionMap)
        {
            return getSetSize((OrionMap<T1, T2, T3>)dataStructure);
        }

        return 0;
    }


    private int getListSize(OrionList<T1> dataStructure)
    {
        return dataStructure.getSize();
    }
    
    
    private int getSetSize(OrionSet<T1> dataStructure)
    {
        return dataStructure.getSize();
    }
    
    
    private int getSetSize(OrionMap<T1, T2, T3> dataStructure)
    {
        return dataStructure.getSize();
    }
}