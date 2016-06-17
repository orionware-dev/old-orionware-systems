package datastructures.facades.lists.factory;

import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionConcurrentArrayList;

public interface ListFactoryFacade<T> extends DataStructuresFacade
{
    public OrionList<T> createEmptyArrayList();
    
    
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList();
}