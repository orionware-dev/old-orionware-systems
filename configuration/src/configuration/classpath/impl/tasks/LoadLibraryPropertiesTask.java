package configuration.classpath.impl.tasks;

import java.io.InputStream;
import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibraryConfiguration;
import configuration.registry.ConfigurationRegistry;
import filesystem.streams.FileSystemStreamsService;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(LibraryConfiguration libraryConfiguration)
    {
        FileSystemStreamsService fileSystemStreamsService = new FileSystemStreamsServiceImpl();
        InputStream propertiesFileInput = fileSystemStreamsService.getFileStream(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        fileSystemStreamsService.closeResource(propertiesFileInput);
    }
}