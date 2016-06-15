package datastructures.services.lists.factory;

import datastructures.lists.OrionConcurrentArrayList;
import datastructures.lists.OrionList;
import datastructures.services.factories.DataStructureFactory;

public interface ListFactoryService<T> extends DataStructureFactory
{
    public OrionList<T> createEmptyArrayList();
    
    
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList();
}