package datastructuresfacadesintegrationtests.dependencyinjection;

import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructuresObject;
import datastructures.facades.size.DataStructureSizeFacade;

public class TestClass2 extends DataStructuresObject
{
    private DataStructureSizeFacade dataStructureSizeFacade;


    public String testThisClassIsRunning()
    {
        return "Running datastructuresfacadesintegrationtests.dependencyinjection.TestClass2...";
    }


    public DataStructureSizeFacade getDataStructureSizeFacade()
    {
        return dataStructureSizeFacade;
    }


    @Injector(ID = "datastructures.facades.size.impl.DataStructureSizeFacadeImpl")
    private void setDataStructureSizeFacade(DataStructureSizeFacade dataStructureSizeFacade)
    {
        this.dataStructureSizeFacade = dataStructureSizeFacade;
    }
}