package datastructures.facades.size;

import datastructures.DataStructure;
import datastructures.DataStructuresFacade;

public interface DataStructureSizeFacade extends DataStructuresFacade
{
    public int getSize(DataStructure dataStructure);
}