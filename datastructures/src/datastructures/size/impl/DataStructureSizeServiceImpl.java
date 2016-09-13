package datastructures.size.impl;

import datastructures.DataStructure;
import datastructures.DataStructuresObject;
import datastructures.size.DataStructureSizeService;
import datastructures.size.impl.tasks.GetSizeTask;

public class DataStructureSizeServiceImpl<T1, T2, T3> extends DataStructuresObject implements DataStructureSizeService<T1, T2, T3>
{
    @Override
    public int getSize(DataStructure dataStructure)
    {
        return new GetSizeTask<T1, T2, T3>().run(dataStructure);
    }
}