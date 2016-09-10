package core.objects.services.orionobject.impl.tasks;

import java.util.Arrays;
import configuration.CoreConfigurationConfigurationEnumeration;
import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.services.OrionTask;
import dependencyinjection.configuration.DependencyInjectionConfigurationEnumeration;

public class InitialiseCoreConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public LibraryConfiguration runCore()
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(CoreConfigurationConfigurationEnumeration.values())
            .forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfigurationTask
            .runCore(CoreConfigurationConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
    
    
    public LibraryConfiguration runDependencyInjection()
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(DependencyInjectionConfigurationEnumeration.values())
            .forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfigurationTask
            .runDependencyInjection(DependencyInjectionConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
}