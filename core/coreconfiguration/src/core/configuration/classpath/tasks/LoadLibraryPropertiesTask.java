package core.configuration.classpath.tasks;

import java.io.InputStream;
import core.OrionSimpleObject;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionConfigurationTask;
import core.configuration.classpath.ConfigurationService;
import core.configuration.registry.ConfigurationRegistry;

public class LoadLibraryPropertiesTask extends OrionSimpleObject implements OrionConfigurationTask
{
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private LibraryConfiguration libraryConfiguration;
    
    
    public void run(GetClasspathRootPathTask getClasspathRootPathTask, ConfigurationService configurationService, LibraryConfiguration libraryConfiguration)
    {
        this.getClasspathRootPathTask = getClasspathRootPathTask;
        this.libraryConfiguration = libraryConfiguration;
        InputStream propertiesFileInput = configurationService.getFileStream(buildLibraryPropertiesFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
    
    
    private String buildLibraryPropertiesFilePath()
    {
        StringBuilder sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryConfiguration.getLibraryName()));
        sb.append(libraryConfiguration.getConfigurationFilePath());
        return sb.toString();
    }
}