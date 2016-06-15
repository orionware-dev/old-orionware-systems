package datastructures.facades.maps.factory.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.facades.maps.factory.MapFactoryFacade;
import datastructures.lists.OrionList;
import datastructures.maps.OrionMap;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.maps.factory.MapFactoryService;
import datastructures.services.maps.factory.impl.MapFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;

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
    public OrionMap<T, T1, T2> createEmptyConcurrentHashMap()
    {
        return mapFactoryService.createEmptyConcurrentHashMap();
    }
}