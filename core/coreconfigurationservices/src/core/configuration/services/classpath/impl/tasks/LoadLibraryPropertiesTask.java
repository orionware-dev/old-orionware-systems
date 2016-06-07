package core.configuration.services.classpath.impl.tasks;

import java.io.Closeable;
import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.registry.ConfigurationRegistry;
import core.runnables.consumers.Consumer1;
import core.runnables.functions.Function1x1;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(LibraryConfiguration libraryConfiguration, Function1x1<String, InputStream> getFileStreamMethod, Consumer1<Closeable> closeResourceMethod)
    {
        InputStream propertiesFileInput = getFileStreamMethod.run(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        closeResourceMethod.run(propertiesFileInput);
    }
}