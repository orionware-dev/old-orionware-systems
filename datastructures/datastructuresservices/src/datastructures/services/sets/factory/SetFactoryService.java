package datastructures.services.sets.factory;

import datastructures.lists.OrionList;
import datastructures.services.factories.DataStructureFactory;
import datastructures.sets.OrionSet;

public interface SetFactoryService<T> extends DataStructureFactory
{
    public OrionSet<T> createEmptyHashSet();
    
    
    public OrionSet<T> createEmptyConcurrentHashSet();
}