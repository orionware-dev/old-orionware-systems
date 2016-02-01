package datastructuresservices.lists.size.impl;

import core.taskdependencyinjection.TaskInjector;
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


    @TaskInjector(ID = "GetSizeTask")
    private void setGetSizeTask(GetSizeTask getSizeTask)
    {
        this.getSizeTask = getSizeTask;
    }
}