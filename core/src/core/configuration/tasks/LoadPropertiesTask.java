package core.configuration.tasks;

import java.io.File;
import java.io.InputStream;
import core.configuration.Configuration;
import core.configuration.ConfigurationService;
import core.registry.OrionProperties;
import core.services.OrionTask;

public class LoadPropertiesTask extends OrionTask
{
    private String libraryName;
    
    
    public Object run(ConfigurationService configurationService, String libraryName, String libraryConfigurationFilePath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        this.libraryName = libraryName;
        
        if(!havePropertiesBeenLoaded())
        {
            StringBuilder sb = new StringBuilder();
            sb.append((String)getClasspathRootPathTask.run(libraryName));
            sb.append(libraryConfigurationFilePath);
            InputStream propertiesFileInput = configurationService.getFileStream(sb.toString());
            OrionProperties.loadProperties(propertiesFileInput);
            configurationService.closeResource(propertiesFileInput);
            setPropertiesAsLoaded();
        }
        
        return null;
    }
    
    
    private boolean havePropertiesBeenLoaded()
    {
        if(Configuration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(libraryName) != null)
        {
            return Configuration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private void setPropertiesAsLoaded()
    {
        Configuration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.put(libraryName, true);
    }
}