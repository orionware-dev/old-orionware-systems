package core.configuration.services.classpath.impl.tasks;

import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.registry.ConfigurationRegistry;
import core.filesystem.facades.streams.FileSystemStreamsFacade;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(LibraryConfiguration libraryConfiguration)
    {
        FileSystemStreamsFacade fileSystemStreamsFacade = new FileSystemStreamsFacadeImpl();
        InputStream propertiesFileInput = fileSystemStreamsFacade.getFileStream(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        fileSystemStreamsFacade.closeResource(propertiesFileInput);
    }
}