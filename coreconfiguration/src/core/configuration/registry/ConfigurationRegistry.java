package core.configuration.registry;

import java.io.InputStream;
import core.configuration.OrionProperties;

public class ConfigurationRegistry
{
    public static void loadProperties(InputStream propertiesFileInput)
    {
        AllProperties.loadProperties(propertiesFileInput);
    }
    
    
    public static OrionProperties getProps()
    {
        return AllProperties.properties;
    }
}