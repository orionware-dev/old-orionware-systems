package core.configuration.registry;

import java.io.InputStream;
import core.OrionSimpleObject;
import core.configuration.OrionProperties;

public class AllProperties extends OrionSimpleObject
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
    
    
    public static void registerProp(String key, String value)
    {
        properties.registerProp(key, value);
    }
    
    
    public static void updateProp(String key, String value)
    {
        properties.updateProp(key, value);
    }
    
    
    public static void deleteProp(String key)
    {
        properties.deleteProp(key);
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