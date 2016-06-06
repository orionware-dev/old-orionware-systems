package core.configuration.services.registry.impl.tasks;

import java.io.Closeable;
import java.io.InputStream;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.services.classpath.impl.tasks.LoadLibraryPropertiesTask;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.consumers.Consumer1;
import core.functions.Function1x1;

public class RegisterLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(LoadLibraryPropertiesTask loadLibraryPropertiesTask, PropertiesRegistrationService propertiesRegistrationService, LibraryConfiguration libraryConfiguration, Function1x1<String, InputStream> getFileStreamMethod, Consumer1<Closeable> closeResourceMethod)
    {
        loadLibraryPropertiesTask.run(libraryConfiguration, getFileStreamMethod, closeResourceMethod);
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
}