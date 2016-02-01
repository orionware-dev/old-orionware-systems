package core.registry;

import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.general.OrionProperties;

public class OrionRegistry
{
    public static void loadProperties(InputStream propertiesFileInput)
    {
        AllProperties.loadProperties(propertiesFileInput);
    }
    
    
    public static OrionProperties getProps()
    {
        return AllProperties.getProps();
    }
    
    
    public static void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    public static Set<RegisteredAnnotation> getAnnotations()
    {
        return RegisteredAnnotations.getAnnotations();
    }
}