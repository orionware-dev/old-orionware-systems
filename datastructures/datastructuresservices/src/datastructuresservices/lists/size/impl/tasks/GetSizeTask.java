package datastructuresservices.lists.size.impl.tasks;

import datastructures.lists.OrionList;
import datastructures.services.DataStructuresTask;

public class GetSizeTask extends DataStructuresTask
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