package datastructures.facades.lists.factory.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.lists.OrionConcurrentArrayList;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;

public class ListFactoryFacadeImpl<T> extends DataStructuresFacadesObject implements ListFactoryFacade<T>
{
    private ListFactoryService<T> listFactoryService;
    
    
    public ListFactoryFacadeImpl()
    {
        
    }
    
    
    @Override
    public OrionList<T> createEmptyArrayList()
    {
        return listFactoryService.createEmptyArrayList();
    }

    @Override
    public OrionConcurrentArrayList<T> createEmptyConcurrentArrayList()
    {
        return listFactoryService.createEmptyConcurrentArrayList();
    }


    @Injector(ID = "datastructures.services.lists.factory.impl.ListFactoryServiceImpl")
    private void setListFactoryService(ListFactoryService<T> listFactoryService)
    {
        this.listFactoryService = listFactoryService;
    }
}