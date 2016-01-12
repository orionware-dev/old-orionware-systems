package datastructuresfacades.size.impl;

import java.util.Collection;
import core.dependencyinjection.Injector;
import datastructures.general.DataStructureObject;
import datastructuresfacades.size.DataStructureSizeFacade;
import datastructuresservices.size.DataStructureSizeService;

public class DataStructureSizeFacadeImpl extends DataStructureObject implements DataStructureSizeFacade
{
    private DataStructureSizeService dataStructureSizeService;
    
    
    @Override
    public int getSize(Collection<?> dataStructure)
    {
        return dataStructureSizeService.getSize(dataStructure);
    }


    @Injector(ID = "datastructuresservices.size.impl.DataStructureSizeServiceImpl")
    private void setDataStructureSizeService(DataStructureSizeService dataStructureSizeService)
    {
        this.dataStructureSizeService = dataStructureSizeService;
    }
}