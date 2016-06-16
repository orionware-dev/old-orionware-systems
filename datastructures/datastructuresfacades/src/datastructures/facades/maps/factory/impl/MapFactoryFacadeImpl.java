package datastructures.facades.maps.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.maps.factory.MapFactoryFacade;
import datastructures.maps.OrionConcurrentHashMap;
import datastructures.maps.OrionMap;
import datastructures.services.maps.factory.MapFactoryService;

public class MapFactoryFacadeImpl<T, T1, T2> extends DataStructuresFacadesObject implements MapFactoryFacade<T, T1, T2>
{
    private MapFactoryService<T, T1, T2> mapFactoryService;
    
    
    public MapFactoryFacadeImpl()
    {
        
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


    @Injector(ID = "datastructures.services.maps.factory.impl.MapFactoryServiceImpl")
    private void setMapFactoryService(MapFactoryService<T, T1, T2> mapFactoryService)
    {
        this.mapFactoryService = mapFactoryService;
    }
}