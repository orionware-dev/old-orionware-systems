package datastructures.lists.factory;

import datastructures.factories.DataStructureFactory;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionConcurrentArrayList;

public interface ListFactoryService<T> extends DataStructureFactory
{
    public OrionList<T> createEmptyArrayList();
    
    
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList();
}