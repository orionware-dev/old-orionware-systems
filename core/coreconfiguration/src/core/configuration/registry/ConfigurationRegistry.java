package core.configuration.registry;

import java.io.InputStream;
import core.configuration.OrionProperties;
import core.general.OrionRegistry;

public class ConfigurationRegistry extends OrionRegistry
{
    public static void loadProperties(InputStream propertiesFileInput)
    {
        AllProperties.loadProperties(propertiesFileInput);
    }
    
    
    public static void registerProp(String key, String value)
    {
        AllProperties.registerProp(key, value);
    }
    
    
    public static void updateProp(String key, String value)
    {
        AllProperties.updateProp(key, value);
    }
    
    
    public static void deleteProp(String key)
    {
        AllProperties.deleteProp(key);
    }
    
    
    public static OrionProperties getProps()
    {
        return AllProperties.properties;
    }
}