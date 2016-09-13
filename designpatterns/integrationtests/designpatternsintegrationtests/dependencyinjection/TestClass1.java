package designpatternsintegrationtests.dependencyinjection;

import dependencyinjection.annotation.Injector;
import designpatterns.DesignPatternsObject;

public class TestClass1 extends DesignPatternsObject
{
    private TestClass2 testClass2;


    public String testThisClassIsRunning()
    {
        return "Running designpatternsintegrationtests.dependencyinjection.TestClass1...";
    }


    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }


    @Injector(ID = "designpatternsintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}