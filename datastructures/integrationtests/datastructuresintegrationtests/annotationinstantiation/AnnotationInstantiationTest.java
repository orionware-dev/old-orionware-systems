package datastructuresintegrationtests.annotationinstantiation;

import java.lang.annotation.Annotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import computation.annotation.Concurrency;
import datastructures.DataStructuresObject;
import dependencyinjection.annotation.Injector;
import tester.ConcurrentJUnitRunner;

@RunWith(ConcurrentJUnitRunner.class)
@Concurrency()
public class AnnotationInstantiationTest extends DataStructuresObject
{
    @Before
    public void setUp() throws Exception
    {

    }
    
    
    @Test
    public void testInjectorAnnotationInstantiation()
    {
        String objectID = "datastructuresintegrationtests.dependencyinjection.TestClass1";
        
        Injector annotation = new Injector()
        {
            @Override
            public String ID()
            {
                return objectID;
            }

            
            @Override
            public Class<? extends Annotation> annotationType()
            {
                return Injector.class;
            }
        };
        
        Assert.assertEquals(objectID, annotation.ID());        
    }
}