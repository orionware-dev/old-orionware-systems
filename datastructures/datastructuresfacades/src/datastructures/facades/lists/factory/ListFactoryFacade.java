package datastructures.facades.lists.factory;

import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;

public interface ListFactoryFacade<T> extends DataStructuresFacade
{
    public OrionList<T> createEmptyArrayList();
    
    
    public OrionList<T> createEmptyConcurrentArrayList();
}