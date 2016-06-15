package datastructures.facades.size.impl;

import core.dependencyinjection.Injector;
import datastructures.DataStructure;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.facades.size.DataStructureSizeFacade;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.SetFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.DataStructureSizeServiceImpl;
import datastructures.sets.OrionSet;

public class DataStructureSizeFacadeImpl extends DataStructuresFacadesObject implements DataStructureSizeFacade
{
    private DataStructureSizeService dataStructureSizeService;
    
    
    public DataStructureSizeFacadeImpl()
    {
        this.dataStructureSizeService = new DataStructureSizeServiceImpl();
    }


    @Override
    public int getSize(DataStructure dataStructure)
    {
        return dataStructureSizeService.getSize(dataStructure);
    }
}