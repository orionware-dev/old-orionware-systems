package datastructures.facades.size.impl;

import datastructures.DataStructure;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.size.DataStructureSizeFacade;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.DataStructureSizeServiceImpl;

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