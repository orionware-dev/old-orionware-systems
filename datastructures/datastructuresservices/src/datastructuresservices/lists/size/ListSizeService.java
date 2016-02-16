package datastructuresservices.lists.size;

import datastructures.DataStructuresService;
import datastructures.lists.OrionList;

public interface ListSizeService extends DataStructuresService
{
    public int getSize(OrionList<?> dataStructure);
}