package datastructures.facades.size;

import datastructures.DataStructure;
import datastructures.DataStructuresFacade;

public interface DataStructureSizeFacade<T1, T2, T3> extends DataStructuresFacade
{
    public int getSize(DataStructure dataStructure);
}