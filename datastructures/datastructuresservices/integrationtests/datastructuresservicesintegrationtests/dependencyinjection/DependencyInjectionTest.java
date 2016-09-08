package datastructuresservicesintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;

public class DependencyInjectionTest extends DataStructuresObject
{
    @Before
    public void setUp() throws Exception
    {
        
    }


    @Test
    public void testDependencyInjection1()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running datastructuresservicesintegrationtests.dependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running datastructuresservicesintegrationtests.dependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
        OrionList<String> dataStructure = new OrionArrayList<String>();
        dataStructure.add("1");
        dataStructure.add("2");
        dataStructure.add("3");
        Assert.assertEquals(3, testClass1.getTestClass2().getDataStructureSizeService().getSize(dataStructure));
    }
}