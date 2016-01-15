package datastructuresservices.lists.size.impl.tasks;

import datastructures.general.DataStructure;
import datastructures.lists.OrionList;
import datastructures.services.DataStructureTask;

public class GetSizeTask extends DataStructureTask
{
    public Integer run(OrionList<?> dataStructure)
    {
        if(dataStructure != null)
        {
            return dataStructure.size();
        }
        
        return 0;
    }
    
    
    public Integer run(DataStructure dataStructure)
    {
        if(dataStructure != null)
        {
            //return dataStructure.size();
        }
        
        return 0;
    }
}