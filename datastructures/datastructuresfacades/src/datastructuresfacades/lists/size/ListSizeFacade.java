package datastructuresfacades.lists.size;

import datastructures.lists.OrionList;
import datastructures.services.DataStructuresFacade;

public interface ListSizeFacade extends DataStructuresFacade
{
    public int getSize(OrionList<?> dataStructure);
}