package datastructuresservicesintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructuresObject;
import datastructures.services.size.DataStructureSizeService;

public class TestClass2 extends DataStructuresObject
{
    private DataStructureSizeService dataStructureSizeService;


    public String testThisClassIsRunning()
    {
        return "Running datastructuresservicesintegrationtests.dependencyinjection.TestClass2...";
    }


    public DataStructureSizeService getListSizeService()
    {
        return dataStructureSizeService;
    }


    @Injector(ID = "datastructures.services.lists.size.impl.ListSizeServiceImpl")
    private void setListSizeService(DataStructureSizeService dataStructureSizeService)
    {
        this.dataStructureSizeService = dataStructureSizeService;
    }
}