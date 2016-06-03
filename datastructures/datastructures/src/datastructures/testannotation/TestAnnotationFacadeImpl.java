package datastructures.testannotation;

import core.OrionSimpleObject;
import core.objects.OrionObject;

public class TestAnnotationFacadeImpl extends OrionSimpleObject
{
    private OrionObject object;
    
    
    public TestAnnotationFacadeImpl()
    {
        
    }
    
    
    public TestAnnotationFacadeImpl(OrionObject object)
    {
        this.object = object;
    }
    
    
    public void processAnnotation()
    {
        TestAnnotation testAnnotation = object.getClass().getAnnotation(TestAnnotation.class);
        
        if(testAnnotation != null)
        {
            System.out.println("processing " + object.getClass().getName());
        }
    }
    
    
    public void printMe()
    {
        System.out.println("I am printed");
    }
}