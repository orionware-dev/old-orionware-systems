package core.configuration.tasks;

import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationService;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;
import core.registry.AllProperties;
import core.services.OrionTask;

public class LoadLibrariesPropertiesTask implements OrionTask
{
    private ConfigurationService configurationService;
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private StringBuilder sb;
    
    
    public void run(ConfigurationService configurationService, Set<LibraryConfiguration> librariesConfiguration, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        this.configurationService = configurationService;
        this.getClasspathRootPathTask = getClasspathRootPathTask;
        loadLibrariesProperties(librariesConfiguration);
    }
    
    
    private void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        sb = null;
        
        for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
        {
            if(libraryConfiguration.getConfigurationFilePath() != null
                            && havePropertiesNotBeenLoadedForLibrary(libraryConfiguration.getLibraryName()))
            {
                loadLibraryProperties(libraryConfiguration);
                setPropertiesAsLoadedForLibrary(libraryConfiguration.getLibraryName());
            }
        }
    }
    
    
    private void loadLibraryProperties(LibraryConfiguration libraryConfiguration)
    {
        InputStream propertiesFileInput = configurationService.getFileStream(buildLibraryPropertiesFilePath(libraryConfiguration));
        AllProperties.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
    
    
    private String buildLibraryPropertiesFilePath(LibraryConfiguration libraryConfiguration)
    {
        sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryConfiguration.getLibraryName()));
        sb.append(libraryConfiguration.getConfigurationFilePath());
        return sb.toString();
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
    
    
    private boolean havePropertiesNotBeenLoadedForLibrary(String libraryName)
    {
        return !havePropertiesBeenLoadedForLibrary(libraryName);
    }
    
    
    private void setPropertiesAsLoadedForLibrary(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.put(libraryName, true);
    }
}