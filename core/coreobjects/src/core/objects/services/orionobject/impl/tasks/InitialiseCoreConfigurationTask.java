package core.objects.services.orionobject.impl.tasks;

import java.util.Arrays;
import core.OrionSimpleObject;
import core.configuration.CoreConfigurationConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import core.dependencyinjection.configuration.CoreDependencyInjectionConfigurationEnumeration;
import core.services.OrionTask;

public class InitialiseCoreConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public LibraryConfiguration runCore()
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(CoreConfigurationConfigurationEnumeration.values()).forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfigurationTask.runCore(CoreConfigurationConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
    
    
    public LibraryConfiguration runDependencyInjection()
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(CoreDependencyInjectionConfigurationEnumeration.values()).forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfigurationTask.runDependencyInjection(CoreDependencyInjectionConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
}