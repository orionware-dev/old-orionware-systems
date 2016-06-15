package datastructures.services.size.impl;

import datastructures.DataStructure;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.tasks.GetSizeTask;

public class DataStructureSizeServiceImpl extends DataStructuresServicesObject implements DataStructureSizeService
{
    @Override
    public int getSize(DataStructure dataStructure)
    {
        return new GetSizeTask().run(dataStructure);
    }
}