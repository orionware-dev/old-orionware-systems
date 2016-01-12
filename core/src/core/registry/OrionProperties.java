package core.registry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import core.general.OrionConfiguration;

public class OrionProperties extends OrionConfiguration
{
    private static Properties properties;
    
    
    static
    {
        properties = new Properties();
    }
    
    
    public static void loadProperties(InputStream propertiesFileInput)
    {
        try
        {
            getProperties().load(propertiesFileInput);
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public static Properties getProperties()
    {
        return properties;
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