package datastructuresservicesintegrationtests.dependencyinjection;

import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructuresObject;
import datastructures.services.size.DataStructureSizeService;

public class TestClass2 extends DataStructuresObject
{
    private DataStructureSizeService dataStructureSizeService;


    public String testThisClassIsRunning()
    {
        return "Running datastructuresservicesintegrationtests.dependencyinjection.TestClass2...";
    }


    public DataStructureSizeService getDataStructureSizeService()
    {
        return dataStructureSizeService;
    }


    @Injector(ID = "datastructures.services.size.impl.DataStructureSizeServiceImpl")
    private void setDataStructureSizeService(DataStructureSizeService dataStructureSizeService)
    {
        this.dataStructureSizeService = dataStructureSizeService;
    }
}