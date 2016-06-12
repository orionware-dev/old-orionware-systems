package datastructures.services.lists.size.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.size.ListSizeService;
import datastructures.services.lists.size.impl.tasks.GetSizeTask;

public class ListSizeServiceImpl extends DataStructuresObject implements ListSizeService
{
    private GetSizeTask getSizeTask;


    public ListSizeServiceImpl()
    {
        this.getSizeTask = new GetSizeTask();
    }


    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return getSizeTask.run(dataStructure);
    }
}