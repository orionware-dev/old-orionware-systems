package core.configuration.services.classpath.impl.tasks;

import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.ConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;
import core.configuration.services.classpath.ConfigurationClasspathService;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(ConfigurationClasspathService configurationClasspathService, LibraryConfiguration libraryConfiguration)
    {
        InputStream propertiesFileInput = configurationClasspathService.getFileStream(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        configurationClasspathService.closeResource(propertiesFileInput);
    }
}