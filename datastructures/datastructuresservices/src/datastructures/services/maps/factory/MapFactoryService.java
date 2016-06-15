package datastructures.services.maps.factory;

import datastructures.maps.OrionMap;
import datastructures.services.factories.DataStructureFactory;

public interface MapFactoryService<T, T1, T2> extends DataStructureFactory
{
    public OrionMap<T, T1, T2> createEmptyHashMap();
    
    
    public OrionMap<T, T1, T2> createEmptyConcurrentHashMap();
}