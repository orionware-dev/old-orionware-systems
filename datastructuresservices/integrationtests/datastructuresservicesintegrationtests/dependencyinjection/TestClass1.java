package datastructuresservicesintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructureObject;
import datastructuresservices.factories.lists.ListFactoryService;

public class TestClass1 extends DataStructureObject
{
    private TestClass2 testClass2;
    private ListFactoryService<?> listFactoryService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresservicesintegrationtests.dependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public TestClass2 getTestClass2()
    {
        return testClass2;
    }
    
    
    @Injector(ID = "datastructuresservicesintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }


    public ListFactoryService<?> getListFactoryService()
    {
        return this.listFactoryService;
    }


    @Injector(ID = "datastructuresservices.factories.lists.impl.ListFactoryServiceImpl")
    private void setListFactoryService(ListFactoryService<?> listFactoryService)
    {
        this.listFactoryService = listFactoryService;
    }
}