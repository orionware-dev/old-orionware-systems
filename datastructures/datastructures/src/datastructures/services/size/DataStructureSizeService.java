package datastructures.services.size;

import datastructures.DataStructure;
import datastructures.DataStructuresService;

public interface DataStructureSizeService extends DataStructuresService
{
    public int getSize(DataStructure dataStructure);
}