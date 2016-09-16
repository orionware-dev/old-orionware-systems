package designpatternsintegrationtests.propertydependencyinjection;

import dependencyinjection.annotation.Prop;
import designpatterns.DesignPatternsObject;

public class TestClass1 extends DesignPatternsObject
{
    @Prop
    private String propertyValue;


    public String getPropertyValue()
    {
        return this.propertyValue;
    }


    @Prop(key = "java.runtime.name")
    public void setPropertyValue(String propertyValue)
    {
        this.propertyValue = propertyValue;
    }
}