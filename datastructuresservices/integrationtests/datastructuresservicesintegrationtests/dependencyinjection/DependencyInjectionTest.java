package datastructuresservicesintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.DataStructureObject;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;

public class DependencyInjectionTest extends DataStructureObject
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
        Assert.assertEquals(3, testClass1.getTestClass2().getListSizeService().getSize(dataStructure));
    }
}