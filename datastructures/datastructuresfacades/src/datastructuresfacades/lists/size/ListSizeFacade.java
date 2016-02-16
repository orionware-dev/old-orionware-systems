package datastructuresfacades.lists.size;

import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;

public interface ListSizeFacade extends DataStructuresFacade
{
    public int getSize(OrionList<?> dataStructure);
}