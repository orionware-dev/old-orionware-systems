package datastructures.facades.maps.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.maps.factory.MapFactoryFacade;
import datastructures.maps.OrionMap;
import datastructures.maps.impl.OrionConcurrentHashMap;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.MapFactoryServiceImpl;

public class MapFactoryFacadeImpl<T, T1, T2> extends DataStructuresFacadesObject implements MapFactoryFacade<T, T1, T2>
{
    private MapFactoryService<T, T1, T2> mapFactoryService;
    
    
    public MapFactoryFacadeImpl()
    {
        this.mapFactoryService = new MapFactoryServiceImpl<T, T1, T2>();
    }


    @Override
    public OrionMap<T, T1, T2> createEmptyHashMap()
    {
        return mapFactoryService.createEmptyHashMap();
    }


    @Override
    public OrionConcurrentHashMap<T, T1, T2> createEmptyConcurrentHashMap()
    {
        return mapFactoryService.createEmptyConcurrentHashMap();
    }
}