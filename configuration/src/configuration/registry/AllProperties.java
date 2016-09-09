package configuration.registry;

import java.io.InputStream;
import java.util.Properties;
import configuration.ConfigurationObject;
import configuration.OrionProperties;

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


    private static boolean keyIsNotEmpty(String key)
    {
        return key != null && !key.isEmpty();
    }


    public static String getProperty(String key)
    {
        if(keyIsNotEmpty(key))
        {
            return properties.getProperty(key);
        }

        return null;
    }


    public static Integer getIntegerProperty(String key)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Integer.parseInt(properties.getProperty(key));
            }
            catch(NumberFormatException e)
            {

            }
        }

        return Integer.MIN_VALUE;
    }


    public static Double getDoubleProperty(String key)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Double.parseDouble(properties.getProperty(key));
            }
            catch(NumberFormatException e)
            {

            }
        }

        return Double.MIN_VALUE;
    }


    public static Boolean getBooleanProperty(String key)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Boolean.parseBoolean(properties.getProperty(key));
            }
            catch(NumberFormatException e)
            {

            }
        }

        return Boolean.FALSE;
    }
}