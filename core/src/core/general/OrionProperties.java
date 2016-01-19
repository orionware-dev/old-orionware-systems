package core.general;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OrionProperties extends Properties
{
    private static final long serialVersionUID = 2244989344408978785L;
    
    
    public void loadProperties(InputStream propertiesFileInput)
    {
        try
        {
            load(propertiesFileInput);
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }
}