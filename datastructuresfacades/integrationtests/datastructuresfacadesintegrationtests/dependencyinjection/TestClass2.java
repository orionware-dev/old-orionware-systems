package datastructuresfacadesintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructureObject;
import datastructuresfacades.lists.size.ListSizeFacade;

public class TestClass2 extends DataStructureObject
{
    private ListSizeFacade listSizeFacade;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresfacadesintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public ListSizeFacade getListSizeFacade()
    {
        return listSizeFacade;
    }
    
    
    @Injector(ID = "datastructuresfacades.lists.size.impl.ListSizeFacadeImpl")
    private void setListSizeFacade(ListSizeFacade listSizeFacade)
    {
        this.listSizeFacade = listSizeFacade;
    }
}