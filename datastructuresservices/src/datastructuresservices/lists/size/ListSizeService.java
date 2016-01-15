package datastructuresservices.lists.size;

import datastructures.lists.OrionList;
import datastructures.services.DataStructureService;

public interface ListSizeService extends DataStructureService
{
    public int getSize(OrionList<?> dataStructure);
}