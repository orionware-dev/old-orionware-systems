package datastructures.facades.size;

import datastructures.DataStructure;
import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;
import datastructures.sets.OrionSet;

public interface DataStructureSizeFacade extends DataStructuresFacade
{
    public int getSize(DataStructure dataStructure);
}