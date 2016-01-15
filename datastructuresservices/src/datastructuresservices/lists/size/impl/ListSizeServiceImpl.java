package datastructuresservices.lists.size.impl;

import core.dependencyinjection.Injector;
import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructuresservices.lists.size.ListSizeService;
import datastructuresservices.lists.size.impl.tasks.GetSizeTask;

public class ListSizeServiceImpl extends DataStructuresObject implements ListSizeService
{
    private GetSizeTask getSizeTask;
    
    
    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return getSizeTask.run(dataStructure);
    }


    @Injector(ID = "datastructuresservices.lists.size.impl.tasks.GetSizeTask")
    private void setGetSizeTask(GetSizeTask getSizeTask)
    {
        this.getSizeTask = getSizeTask;
    }
}