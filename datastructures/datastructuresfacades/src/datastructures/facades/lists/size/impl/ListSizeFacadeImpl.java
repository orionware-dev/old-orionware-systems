package datastructures.facades.lists.size.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.size.ListSizeFacade;
import datastructures.lists.OrionList;
import datastructures.services.size.DataStructureSizeService;

public class ListSizeFacadeImpl extends DataStructuresFacadesObject implements ListSizeFacade
{
    private DataStructureSizeService dataStructureSizeService;


    @Override
    public int getSize(OrionList<?> dataStructure)
    {
        return dataStructureSizeService.getSize(dataStructure);
    }


    @Injector(ID = "datastructures.services.lists.size.ListSizeService")
    private void setListSizeService(DataStructureSizeService dataStructureSizeService)
    {
        this.dataStructureSizeService = dataStructureSizeService;
    }
}