package configuration.registry;

import java.io.InputStream;
import configuration.OrionProperties;
import core.abstraction.OrionRegistry;
import core.tuples.KeyValuePair;

public class ConfigurationRegistry extends OrionRegistry
{
    public static synchronized void loadProperties(InputStream propertiesFileInput)
    {
        AllProperties.loadProperties(propertiesFileInput);
    }


    public static synchronized void loadProperties(OrionProperties orionProperties)
    {
        AllProperties.loadProperties(orionProperties);
    }


    public static synchronized void registerProp(String key, String value)
    {
        AllProperties.registerProp(key, value);
    }


    public static synchronized void registerProp(KeyValuePair<String, String> keyValuePair)
    {
        registerProp((String)keyValuePair.getFirst(), (String)keyValuePair.getSecond());
    }


    public static synchronized void updateProp(String key, String value)
    {
        AllProperties.updateProp(key, value);
    }


    public static synchronized void updateProp(KeyValuePair<String, String> keyValuePair)
    {
        updateProp((String)keyValuePair.getFirst(), (String)keyValuePair.getSecond());
    }


    public static synchronized void deleteProp(String key)
    {
        AllProperties.deleteProp(key);
    }


    public static OrionProperties getProps()
    {
        return AllProperties.properties;
    }
    
    
    public static String getProp(String key)
    {
        return getProps().getProp(key);
    }
}