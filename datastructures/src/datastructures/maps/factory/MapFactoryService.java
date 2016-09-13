package datastructures.maps.factory;

import datastructures.factories.DataStructureFactory;
import datastructures.maps.OrionMap;
import datastructures.maps.impl.OrionConcurrentHashMap;

public interface MapFactoryService<T, T1, T2> extends DataStructureFactory
{
    public OrionMap<T, T1, T2> createEmptyHashMap();
    
    
    public OrionConcurrentHashMap<T, T1, T2> createEmptyConcurrentHashMap();
}