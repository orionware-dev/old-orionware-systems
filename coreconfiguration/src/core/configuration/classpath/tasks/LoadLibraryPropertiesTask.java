package core.configuration.classpath.tasks;

import java.io.InputStream;
import core.configuration.OrionConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.registry.ConfigurationRegistry;

public class LoadLibraryPropertiesTask implements OrionConfigurationTask
{
    private GetCoreClasspathRootPathTask getCoreClasspathRootPathTask;
    private LibraryConfiguration libraryConfiguration;
    private StringBuilder sb = new StringBuilder();
    
    
    public void run(GetCoreClasspathRootPathTask getCoreClasspathRootPathTask, ConfigurationService configurationService, LibraryConfiguration libraryConfiguration)
    {
        this.getCoreClasspathRootPathTask = getCoreClasspathRootPathTask;
        this.libraryConfiguration = libraryConfiguration;
        InputStream propertiesFileInput = configurationService.getFileStream(buildLibraryPropertiesFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
    
    
    private String buildLibraryPropertiesFilePath()
    {
        sb.append((String)getCoreClasspathRootPathTask.run(libraryConfiguration.getLibraryName()));
        sb.append(libraryConfiguration.getConfigurationFilePath());
        return sb.toString();
    }
}