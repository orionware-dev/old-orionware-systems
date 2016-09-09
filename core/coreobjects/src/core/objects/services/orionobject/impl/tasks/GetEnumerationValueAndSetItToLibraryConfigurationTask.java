package core.objects.services.orionobject.impl.tasks;

import core.OrionSimpleObject;
import configuration.CoreConfigurationConfigurationEnumeration;
import configuration.LibraryConfiguration;
import dependencyinjection.configuration.DependencyInjectionConfigurationEnumeration;
import core.services.OrionTask;

public class GetEnumerationValueAndSetItToLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    @SuppressWarnings("rawtypes")
    public void runCore(Class<CoreConfigurationConfigurationEnumeration> coreConfigurationEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().runCore(coreConfigurationEnumerationClass, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
    
    
    @SuppressWarnings("rawtypes")
    public void runDependencyInjection(Class<DependencyInjectionConfigurationEnumeration> dependencyInjectionConfigurationEnumeration, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().runDependencyInjection(dependencyInjectionConfigurationEnumeration, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
}