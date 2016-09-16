package designpatternsintegrationtests.propertydependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import computation.annotation.Concurrency;
import designpatterns.DesignPatternsObject;
import tester.ConcurrentJUnitRunner;

@RunWith(ConcurrentJUnitRunner.class)
@Concurrency()
public class PropertyDependencyInjectionTest extends DesignPatternsObject
{
    @Before
    public void setUp() throws Exception
    {
        
    }


    @Test
    public void testPropertyDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Java(TM) SE Runtime Environment", testClass1.getPropertyValue());
    }
}