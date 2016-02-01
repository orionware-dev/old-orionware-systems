package core.registry;

import java.io.InputStream;
import core.general.OrionConfiguration;
import core.general.OrionProperties;

public class AllProperties extends OrionConfiguration
{
    private static OrionProperties properties;
    
    
    static
    {
        properties = new OrionProperties();
    }
    
    
    public static void loadProperties(InputStream propertiesFileInput)
    {
        properties.loadProperties(propertiesFileInput);
    }
    
    
    public static OrionProperties getProps()
    {
        return properties;
    }
    
    
    public static boolean isNotEmpty()
    {
        return properties.isNotEmpty();
    }
    
    
    public static String getProperty(String key)
    {
        if(key != null && !key.isEmpty())
        {
            return properties.getProperty(key);
        }
        
        return null;
    }
}