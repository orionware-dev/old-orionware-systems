package datastructuresservices.lists.size;

import datastructures.lists.OrionList;
import datastructures.services.DataStructuresService;

public interface ListSizeService extends DataStructuresService
{
    public int getSize(OrionList<?> dataStructure);
}