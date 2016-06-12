package datastructures.services.lists.size.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresServicesObject;

public class GetSizeTask extends DataStructuresServicesObject implements DataStructuresTask
{
    public int run(OrionList<?> dataStructure)
    {
        if(dataStructure != null)
        {
            return getListSize(dataStructure);
        }

        return 0;
    }


    private int getListSize(OrionList<?> dataStructure)
    {
        return dataStructure.size();
    }
}