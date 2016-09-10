package core.objects.services.orionobject.impl.tasks;

import configuration.CoreConfigurationConfigurationEnumeration;
import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.services.OrionTask;
import dependencyinjection.configuration.DependencyInjectionConfigurationEnumeration;

public class GetEnumerationValueAndSetItToLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    @SuppressWarnings("rawtypes")
    public void runCore(Class<CoreConfigurationConfigurationEnumeration> coreConfigurationEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().getEnumerationValueForCore(coreConfigurationEnumerationClass, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
    
    
    @SuppressWarnings("rawtypes")
    public void runDependencyInjection(Class<DependencyInjectionConfigurationEnumeration> dependencyInjectionConfigurationEnumeration, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().getEnumerationValueForDependencyInjection(dependencyInjectionConfigurationEnumeration, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
}