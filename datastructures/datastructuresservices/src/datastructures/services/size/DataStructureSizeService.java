package datastructures.services.size;

import datastructures.DataStructure;
import datastructures.DataStructuresService;
import datastructures.lists.OrionList;

public interface DataStructureSizeService extends DataStructuresService
{
    public int getSize(DataStructure dataStructure);
}