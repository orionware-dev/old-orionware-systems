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
        getProperties().loadProperties(propertiesFileInput);
    }
    
    
    public static OrionProperties getProperties()
    {
        return properties;
    }
    
    
    public static boolean isNotEmpty()
    {
        return getProperties().isNotEmpty();
    }
    
    
    public static String getProperty(String key)
    {
        if(key != null && !key.isEmpty())
        {
            return getProperties().getProperty(key);
        }
        
        return null;
    }
}