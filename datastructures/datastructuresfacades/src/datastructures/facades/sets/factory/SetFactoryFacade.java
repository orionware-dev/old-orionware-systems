package datastructures.facades.sets.factory;

import datastructures.DataStructuresFacade;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionConcurrentSet;

public interface SetFactoryFacade<T> extends DataStructuresFacade
{
    public OrionSet<T> createEmptyHashSet();
    
    
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet();
}