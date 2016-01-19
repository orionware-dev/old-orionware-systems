package designpatternsintegrationtests.testannotation;

import org.junit.Before;
import org.junit.Test;
import core.OrionObject;

public class DependencyInjectionTest extends OrionObject
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDependencyInjection()
    {
        new TestClass1();
    }
}