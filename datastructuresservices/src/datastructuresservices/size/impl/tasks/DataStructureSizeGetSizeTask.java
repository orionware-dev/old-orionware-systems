package datastructuresservices.size.impl.tasks;

import java.util.Collection;
import datastructures.services.DataStructureTask;

public class DataStructureSizeGetSizeTask extends DataStructureTask
{
    private Collection<?> dataStructure;
    
    
    public void setDataStructure(Collection<?> dataStructure)
    {
        this.dataStructure = dataStructure;
    }
    
    
    public Integer run()
    {
        if(dataStructure != null)
        {
            return dataStructure.size();
        }
        
        return 0;
    }
}