package datastructuresservices.lists.size.impl;

import java.util.Collection;
import core.dependencyinjection.Injector;
import datastructures.DataStructureObject;
import datastructuresservices.lists.size.DataStructureSizeService;
import datastructuresservices.lists.size.impl.tasks.DataStructureSizeGetSizeTask;

public class DataStructureSizeServiceImpl extends DataStructureObject implements DataStructureSizeService
{
    private DataStructureSizeGetSizeTask getSizeTask;
    
    
    @Override
    public int getSize(Collection<?> dataStructure)
    {
        getSizeTask.setDataStructure(dataStructure);
        return getSizeTask.run();
    }


    @Injector(ID = "datastructuresservices.size.impl.tasks.DataStructureSizeGetSizeTask")
    private void setGetSizeTask(DataStructureSizeGetSizeTask getSizeTask)
    {
        this.getSizeTask = getSizeTask;
    }
}