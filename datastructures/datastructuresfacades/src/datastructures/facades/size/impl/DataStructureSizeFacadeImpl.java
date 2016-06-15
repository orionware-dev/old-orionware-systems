package datastructures.facades.size.impl;

import core.dependencyinjection.Injector;
import datastructures.DataStructure;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.size.DataStructureSizeFacade;
import datastructures.services.size.DataStructureSizeService;

public class DataStructureSizeFacadeImpl extends DataStructuresFacadesObject implements DataStructureSizeFacade
{
    private DataStructureSizeService dataStructureSizeService;
    
    
    public DataStructureSizeFacadeImpl()
    {
        
    }


    @Override
    public int getSize(DataStructure dataStructure)
    {
        return dataStructureSizeService.getSize(dataStructure);
    }


    @Injector(ID = "datastructures.services.size.impl.DataStructureSizeServiceImpl")
    private void setDataStructureSizeService(DataStructureSizeService dataStructureSizeService)
    {
        this.dataStructureSizeService = dataStructureSizeService;
    }
}