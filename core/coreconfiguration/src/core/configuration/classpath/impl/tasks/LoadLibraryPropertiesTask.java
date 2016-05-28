package core.configuration.classpath.impl.tasks;

import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionConfigurationTask;
import core.configuration.classpath.ConfigurationService;
import core.configuration.registry.ConfigurationRegistry;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements OrionConfigurationTask
{
    public void run(ConfigurationService configurationService, LibraryConfiguration libraryConfiguration)
    {
        InputStream propertiesFileInput = configurationService.getFileStream(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        configurationService.closeResource(propertiesFileInput);
    }
}