package core.configuration.registry;

import java.io.InputStream;
import java.util.Properties;
import core.configuration.ConfigurationObject;
import core.configuration.OrionProperties;

public class AllProperties extends ConfigurationObject
{
    private static boolean systemPropertiesHaveBeenRegistered = false;
    public static OrionProperties properties;
    
    
    static
    {
        properties = new OrionProperties();
        
        if(!systemPropertiesHaveBeenRegistered)
        {
            loadProperties(System.getProperties());
            systemPropertiesHaveBeenRegistered = true;
        }
    }
    
    
    public static synchronized void loadProperties(InputStream propertiesFileInput)
    {
        properties.loadProperties(propertiesFileInput);
    }
    
    
    public static synchronized void loadProperties(Properties otherProperties)
    {
        properties.loadProperties(otherProperties);
    }
    
    
    public static synchronized void registerProp(String key, String value)
    {
        properties.registerProp(key, value);
    }
    
    
    public static synchronized void updateProp(String key, String value)
    {
        properties.updateProp(key, value);
    }
    
    
    public static synchronized void deleteProp(String key)
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