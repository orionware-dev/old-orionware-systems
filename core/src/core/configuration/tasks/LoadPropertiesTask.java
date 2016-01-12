package core.configuration.tasks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import core.configuration.Configuration;
import core.configuration.ConfigurationService;
import core.registry.OrionProperties;
import core.services.OrionTask;

public class LoadPropertiesTask implements OrionTask
{
    private ConfigurationService configurationService;
    private String libraryConfigurationFilePath;
    private String libraryName;
    
    
    public LoadPropertiesTask(ConfigurationService configurationService, String libraryName, String libraryConfigurationFilePath)
    {
        this.configurationService = configurationService;
        this.libraryName = libraryName;
        this.libraryConfigurationFilePath = libraryConfigurationFilePath;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        if(!havePropertiesBeenLoaded())
        {
            loadProperties();
        }
        
        return null;
    }
    
    
    private void loadProperties()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new File((String)new GetClasspathRootTask(libraryName).execute()).getAbsolutePath());
        sb.append(libraryConfigurationFilePath);
        InputStream propertiesFileInput = configurationService.getFileSystemService().getFileStream(sb.toString());
        OrionProperties.loadProperties(propertiesFileInput);
        configurationService.getFileSystemService().closeResource(propertiesFileInput);
        setPropertiesAsLoaded();
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


    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}