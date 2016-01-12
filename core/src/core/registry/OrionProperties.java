package core.registry;

import java.util.Properties;
import core.general.OrionConfiguration;

public class OrionProperties extends OrionConfiguration
{
    public static Properties properties;
    
    
    static
    {
        properties = new Properties();
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