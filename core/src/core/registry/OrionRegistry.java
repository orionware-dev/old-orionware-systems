package core.registry;

import java.io.InputStream;
import java.util.Set;
import java.util.function.Consumer;
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
        return AllProperties.properties;
    }
    
    
    public static void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    public static Set<RegisteredAnnotation> getAnnotations()
    {
        return RegisteredAnnotations.registeredAnnotationsSet;
    }
    
    
    @SuppressWarnings("unchecked")
    public static void forEach(Consumer<?> action)
    {
        getAnnotations().forEach((Consumer<? super RegisteredAnnotation>)action);
    }
}