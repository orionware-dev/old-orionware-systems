package datastructures.facades.size.impl;

import datastructures.DataStructure;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.size.DataStructureSizeFacade;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.DataStructureSizeServiceImpl;

public class DataStructureSizeFacadeImpl<T1, T2, T3> extends DataStructuresFacadesObject implements DataStructureSizeFacade<T1, T2, T3>
{
    private DataStructureSizeService<T1, T2, T3> dataStructureSizeService;
    
    
    public DataStructureSizeFacadeImpl()
    {
        this.dataStructureSizeService = new DataStructureSizeServiceImpl<T1, T2, T3>();
    }


    @Override
    public int getSize(DataStructure dataStructure)
    {
        return dataStructureSizeService.getSize(dataStructure);
    }
}