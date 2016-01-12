package designpatternsintegrationtests.testannotation;

import org.junit.Before;
import org.junit.Test;
import core.orion.OrionObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Assert;

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