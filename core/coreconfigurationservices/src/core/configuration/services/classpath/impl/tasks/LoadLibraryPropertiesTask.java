package core.configuration.services.classpath.impl.tasks;

import java.io.Closeable;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.Function;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.registry.ConfigurationRegistry;

public class LoadLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(LibraryConfiguration libraryConfiguration, Function<String, InputStream> getFileStreamMethod, Consumer<Closeable> closeResourceMethod)
    {
        InputStream propertiesFileInput = getFileStreamMethod.apply(libraryConfiguration.getConfigurationFilePath());
        ConfigurationRegistry.loadProperties(propertiesFileInput);
        closeResourceMethod.accept(propertiesFileInput);
    }
}