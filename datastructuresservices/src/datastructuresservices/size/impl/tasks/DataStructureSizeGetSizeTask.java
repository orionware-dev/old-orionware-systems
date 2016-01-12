package datastructuresservices.size.impl.tasks;

import java.util.Collection;
import datastructures.general.DataStructureObject;
import datastructures.services.DataStructureTask;

public class DataStructureSizeGetSizeTask extends DataStructureObject implements DataStructureTask
{
    private Collection<?> dataStructure;
    
    
    public void setDataStructure(Collection<?> dataStructure)
    {
        this.dataStructure = dataStructure;
    }
    
    
    @Override
    public Integer run()
    {
        if(dataStructure != null)
        {
            return dataStructure.size();
        }
        
        return 0;
    }


    @Override
    public Object[] executeAndReturnArray()
    {
        return null;
    }
}