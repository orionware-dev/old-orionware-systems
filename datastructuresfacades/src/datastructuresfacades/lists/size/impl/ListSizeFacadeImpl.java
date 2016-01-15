package datastructuresfacades.lists.size.impl;

import core.dependencyinjection.Injector;
import datastructures.lists.OrionList;
import datastructuresfacades.DataStructureFacadeObject;
import datastructuresfacades.lists.size.ListSizeFacade;
import datastructuresservices.lists.size.ListSizeService;

public class ListSizeFacadeImpl extends DataStructureFacadeObject implements ListSizeFacade
{
    private ListSizeService listSizeService;
    
    
    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return listSizeService.getSize(dataStructure);
    }


    @Injector(ID = "datastructuresservices.lists.size.impl.ListSizeServiceImpl")
    private void setListSizeService(ListSizeService listSizeService)
    {
        this.listSizeService = listSizeService;
    }
}