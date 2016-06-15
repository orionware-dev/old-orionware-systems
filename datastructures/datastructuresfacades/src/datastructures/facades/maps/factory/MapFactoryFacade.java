package datastructures.facades.maps.factory;

import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;

public interface MapFactoryFacade<T, T1, T2> extends DataStructuresFacade
{
    public OrionMap<T, T1, T2> createEmptyHashMap();
    
    
    public OrionMap<T, T1, T2> createEmptyConcurrentHashMap();
}