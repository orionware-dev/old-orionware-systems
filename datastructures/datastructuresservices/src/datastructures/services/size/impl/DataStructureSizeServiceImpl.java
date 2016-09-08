package datastructures.services.size.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructure;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.tasks.GetSizeTask;

public class DataStructureSizeServiceImpl<T1, T2, T3> extends DataStructuresServicesObject implements DataStructureSizeService
{
    private GetSizeTask<T1, T2, T3> getSizeTask;
    
    
    public DataStructureSizeServiceImpl()
    {
        
    }
    
    
    @Override
    public int getSize(DataStructure dataStructure)
    {
        return getSizeTask.run(dataStructure);
    }


    @Injector(ID = "datastructures.services.size.impl.tasks.GetSizeTask")
    private void setGetSizeTask(GetSizeTask<T1, T2, T3> getSizeTask)
    {
        this.getSizeTask = getSizeTask;
    }
}