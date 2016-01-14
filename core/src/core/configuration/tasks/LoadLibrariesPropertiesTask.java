package core.configuration.tasks;

import java.io.InputStream;
import java.util.Set;
import core.configuration.CoreConfiguration;
import core.configuration.LibraryConfiguration;
import core.configuration.ConfigurationService;
import core.general.Pair;
import core.registry.OrionProperties;
import core.services.OrionTask;

public class LoadLibrariesPropertiesTask implements OrionTask
{
    private String currentLibraryName;
    
    
    public Object run(ConfigurationService configurationService, Set<LibraryConfiguration> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        if(!havePropertiesBeenLoaded())
        {
            StringBuilder sb = new StringBuilder();
            
            if(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths != null)
            {
                for(Pair<String, String> libraryNameAndConfigurationFilePath : libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths)
                {
                    currentLibraryName = libraryNameAndConfigurationFilePath.getOne();
                    sb = new StringBuilder();
                    sb.append((String)getClasspathRootPathTask.run(libraryNameAndConfigurationFilePath.getOne()));
                    sb.append(libraryNameAndConfigurationFilePath.getTwo());
                    InputStream propertiesFileInput = configurationService.getFileStream(sb.toString());
                    OrionProperties.loadProperties(propertiesFileInput);
                    configurationService.closeResource(propertiesFileInput);
                }
            }
            
            setPropertiesAsLoaded();
        }
        
        return null;
    }
    
    
    private boolean havePropertiesBeenLoaded()
    {
        if(CoreConfiguration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(currentLibraryName) != null)
        {
            return CoreConfiguration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.get(currentLibraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private void setPropertiesAsLoaded()
    {
        CoreConfiguration.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER.put(currentLibraryName, true);
    }
}