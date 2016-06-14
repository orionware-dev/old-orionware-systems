package datastructures.services.lists.size.impl;

import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.size.ListSizeService;
import datastructures.services.lists.size.impl.tasks.GetSizeTask;

public class ListSizeServiceImpl extends DataStructuresObject implements ListSizeService
{
    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return new GetSizeTask().run(dataStructure);
    }
}