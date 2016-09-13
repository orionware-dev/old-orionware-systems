package datastructures.sets.factory;

import datastructures.factories.DataStructureFactory;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionConcurrentSet;

public interface SetFactoryService<T> extends DataStructureFactory
{
    public OrionSet<T> createEmptyHashSet();
    
    
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet();
}