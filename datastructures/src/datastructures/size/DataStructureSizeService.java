package datastructures.size;

import datastructures.DataStructure;
import datastructures.DataStructuresService;

public interface DataStructureSizeService<T1, T2, T3> extends DataStructuresService
{
    public int getSize(DataStructure dataStructure);
}