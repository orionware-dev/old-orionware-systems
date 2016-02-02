package core.registry;

import java.io.InputStream;
import core.general.OrionConfiguration;
import core.general.OrionProperties;

public class AllProperties extends OrionConfiguration
{
    public static OrionProperties properties;
    
    
    static
    {
        properties = new OrionProperties();
    }
    
    
    public static void loadProperties(InputStream propertiesFileInput)
    {
        properties.loadProperties(propertiesFileInput);
    }
    
    
    public static boolean isNotEmpty()
    {
        return properties.isNotEmpty();
    }
    
    
    public static String getProperty(String key)
    {
        if(keyIsNotEmpty(key))
        {
            return properties.getProperty(key);
        }
        
        return null;
    }
    
    
    private static boolean keyIsNotEmpty(String key)
    {
        return key != null && !key.isEmpty();
    }
}