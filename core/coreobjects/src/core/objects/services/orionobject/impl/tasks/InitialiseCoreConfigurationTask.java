package core.objects.services.orionobject.impl.tasks;

import java.util.Arrays;
import core.OrionSimpleObject;
import core.configuration.CoreConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class InitialiseCoreConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public LibraryConfiguration run()
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(CoreConfigurationEnumeration.values())
            .forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfigurationTask.run(CoreConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
}