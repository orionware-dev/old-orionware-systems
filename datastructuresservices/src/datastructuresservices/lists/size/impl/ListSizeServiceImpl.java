package datastructuresservices.lists.size.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructuresservices.lists.size.ListSizeService;
import datastructuresservices.lists.size.impl.tasks.GetSizeTask;

public class ListSizeServiceImpl extends DataStructuresObject implements ListSizeService
{
    private GetSizeTask getSizeTask = new GetSizeTask();
    
    
    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return getSizeTask.run(dataStructure);
    }
}