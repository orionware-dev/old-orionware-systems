package datastructures.services.maps.factory;

import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;
import datastructures.services.factories.DataStructureFactory;
import datastructures.sets.OrionSet;

public interface MapFactoryService<T, T1, T2> extends DataStructureFactory
{
    public OrionMap<T, T1, T2> createEmptyHashMap();
}