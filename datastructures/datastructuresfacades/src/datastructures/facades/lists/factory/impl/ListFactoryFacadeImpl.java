package datastructures.facades.lists.factory.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;

public class ListFactoryFacadeImpl<T> extends DataStructuresFacadesObject implements ListFactoryFacade<T>
{
    private ListFactoryService<T> listFactoryService;
    
    
    public ListFactoryFacadeImpl()
    {
        this.listFactoryService = new ListFactoryServiceImpl<T>();
    }
    
    
    @Override
    public OrionList<T> createEmptyArrayList()
    {
        return listFactoryService.createEmptyArrayList();
    }

    @Override
    public OrionList<T> createEmptyConcurrentArrayList()
    {
        return listFactoryService.createEmptyConcurrentArrayList();
    }
}