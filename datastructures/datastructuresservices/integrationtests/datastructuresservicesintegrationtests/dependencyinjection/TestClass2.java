package datastructuresservicesintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructuresObject;
import datastructures.services.lists.size.ListSizeService;

public class TestClass2 extends DataStructuresObject
{
    private ListSizeService listSizeService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresservicesintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public ListSizeService getListSizeService()
    {
        return listSizeService;
    }
    
    
    @Injector(ID = "datastructures.services.lists.size.impl.ListSizeServiceImpl")
    private void setListSizeService(ListSizeService listSizeService)
    {
        this.listSizeService = listSizeService;
    }
}