package datastructuresservices.lists.size.impl.tasks;

import datastructures.lists.OrionList;
import datastructures.services.DataStructureTask;

public class GetSizeTask extends DataStructureTask
{
    public int run(OrionList<?> dataStructure)
    {
        if(dataStructure != null)
        {
            return dataStructure.size();
        }
        
        return 0;
    }
}