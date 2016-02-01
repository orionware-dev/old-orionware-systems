package core.configuration.tasks;

import java.io.InputStream;
import core.configuration.ConfigurationService;
import core.configuration.LibraryConfiguration;
import core.registry.AllProperties;
import core.registry.OrionRegistry;
import core.services.OrionTask;

public class LoadLibraryPropertiesTask implements OrionTask
{
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private LibraryConfiguration libraryConfiguration;
    private StringBuilder sb;
    
    
    public void run(GetClasspathRootPathTask getClasspathRootPathTask, ConfigurationService configurationService, LibraryConfiguration libraryConfiguration)
    {
        this.getClasspathRootPathTask = getClasspathRootPathTask;
        this.libraryConfiguration = libraryConfiguration;
        sb = new StringBuilder();
        InputStream propertiesFileInput = configurationService.getFileStream(buildLibraryPropertiesFilePath());
        OrionRegistry.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
    
    
    private String buildLibraryPropertiesFilePath()
    {
        sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryConfiguration.getLibraryName()));
        sb.append(libraryConfiguration.getConfigurationFilePath());
        return sb.toString();
    }
}