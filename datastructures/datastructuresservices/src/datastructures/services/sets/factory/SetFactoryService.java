package datastructures.services.sets.factory;

import datastructures.services.factories.DataStructureFactory;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;

public interface SetFactoryService<T> extends DataStructureFactory
{
    public OrionSet<T> createEmptyHashSet();
    
    
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet();
}