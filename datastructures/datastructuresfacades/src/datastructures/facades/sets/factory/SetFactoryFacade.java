package datastructures.facades.sets.factory;

import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;

public interface SetFactoryFacade<T> extends DataStructuresFacade
{
    public OrionSet<T> createEmptyHashSet();
    
    
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet();
}