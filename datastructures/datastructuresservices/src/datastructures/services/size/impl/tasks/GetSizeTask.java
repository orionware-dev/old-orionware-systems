package datastructures.services.size.impl.tasks;

import java.util.HashMap;
import java.util.Map;
import datastructures.DataStructure;
import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionSet;

public class GetSizeTask extends DataStructuresServicesObject implements DataStructuresTask
{
    public int run(DataStructure dataStructure)
    {
        if(dataStructure instanceof OrionList)
        {
            return getListSize((OrionList<?>)dataStructure);
        }
        else if(dataStructure instanceof OrionSet)
        {
            return getSetSize((OrionSet<?>)dataStructure);
        }
        else if(dataStructure instanceof OrionMap)
        {
            return getSetSize((OrionMap<?, ?, ?>)dataStructure);
        }

        return 0;
    }


    private int getListSize(OrionList<?> dataStructure)
    {
        return dataStructure.getSize();
    }
    
    
    private int getSetSize(OrionSet<?> dataStructure)
    {
        return dataStructure.getSize();
    }
    
    
    private int getSetSize(OrionMap<?, ?, ?> dataStructure)
    {
        return dataStructure.getSize();
    }
}