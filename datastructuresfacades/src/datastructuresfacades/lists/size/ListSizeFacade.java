package datastructuresfacades.lists.size;

import datastructures.lists.OrionList;
import datastructures.services.DataStructureFacade;

public interface ListSizeFacade extends DataStructureFacade
{
    public int getSize(OrionList<?> dataStructure);
}