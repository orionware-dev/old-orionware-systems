package core.configuration.tasks;

import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationService;
import core.configuration.CoreConfiguration;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;
import core.general.Pair;
import core.registry.OrionProperties;
import core.services.OrionTask;

public class LoadLibrariesPropertiesTask implements OrionTask
{
    private ConfigurationService configurationService;
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private StringBuilder sb;
    
    
    public Object run(ConfigurationService configurationService, Set<LibraryConfiguration> librariesConfiguration, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        this.configurationService = configurationService;
        this.getClasspathRootPathTask = getClasspathRootPathTask;
        
        if(librariesConfiguration != null)
        {
            sb = null;
            
            for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
            {
                if(!havePropertiesBeenLoadedForLibrary(libraryConfiguration.getLibraryName()))
                {
                    loadLibraryProperties(libraryConfiguration);
                    setPropertiesAsLoadedForLibrary(libraryConfiguration.getLibraryName());
                }
            }
        }
        
        return null;
    }
    
    
    private void loadLibraryProperties(LibraryConfiguration libraryConfiguration)
    {
        sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryConfiguration.getLibraryName()));
        sb.append(libraryConfiguration.getConfigurationFilePath());
        InputStream propertiesFileInput = configurationService.getFileStream(sb.toString());
        OrionProperties.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
    
    
    private boolean havePropertiesBeenLoadedForLibrary(String libraryName)
    {
        if(LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(libraryName) != null)
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private void setPropertiesAsLoadedForLibrary(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.put(libraryName, true);
    }
}