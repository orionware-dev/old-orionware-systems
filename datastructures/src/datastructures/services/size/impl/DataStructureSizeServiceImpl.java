package datastructures.services.size.impl;

import datastructures.DataStructure;
import datastructures.DataStructuresObject;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.tasks.GetSizeTask;

public class DataStructureSizeServiceImpl<T1, T2, T3> extends DataStructuresObject implements DataStructureSizeService<T1, T2, T3>
{
    private GetSizeTask<T1, T2, T3> getSizeTask;
    
    
    public DataStructureSizeServiceImpl()
    {
        this.getSizeTask = new GetSizeTask<T1, T2, T3>();
    }
    
    
    @Override
    public int getSize(DataStructure dataStructure)
    {
        return getSizeTask.run(dataStructure);
    }
}