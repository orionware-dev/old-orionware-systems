package datastructures.facades.lists.size.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.size.ListSizeFacade;
import datastructures.lists.OrionList;
import datastructures.services.lists.size.ListSizeService;

public class ListSizeFacadeImpl extends DataStructuresFacadesObject implements ListSizeFacade
{
    private ListSizeService listSizeService;
    
    
    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return listSizeService.getSize(dataStructure);
    }


    @Injector(ID = "datastructures.services.lists.size.ListSizeService")
    private void setListSizeService(ListSizeService listSizeService)
    {
        this.listSizeService = listSizeService;
    }
}