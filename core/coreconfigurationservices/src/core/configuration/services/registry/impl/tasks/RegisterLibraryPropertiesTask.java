package core.configuration.services.registry.impl.tasks;

import java.io.Closeable;
import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.consumers.Consumer1;
import core.consumers.Consumer3;
import core.functions.Function1x1;

public class RegisterLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(Consumer3<LibraryConfiguration, Function1x1<String, InputStream>, Consumer1<Closeable>> loadLibraryPropertiesMethod, Consumer1<String> setPropertiesAsRegisteredForLibraryMethod, LibraryConfiguration libraryConfiguration, Function1x1<String, InputStream> getFileStreamMethod, Consumer1<Closeable> closeResourceMethod)
    {
        loadLibraryPropertiesMethod.run(libraryConfiguration, getFileStreamMethod, closeResourceMethod);
        setPropertiesAsRegisteredForLibraryMethod.run(libraryConfiguration.getLibraryName());
    }
}