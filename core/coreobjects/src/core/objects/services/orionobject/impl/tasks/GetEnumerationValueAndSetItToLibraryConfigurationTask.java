package core.objects.services.orionobject.impl.tasks;

import core.OrionSimpleObject;
import core.configuration.CoreConfigurationConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import core.dependencyinjection.configuration.CoreDependencyInjectionConfigurationEnumeration;
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
    public void runDependencyInjection(Class<CoreDependencyInjectionConfigurationEnumeration> coreDependencyInjectionConfigurationEnumeration, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().runDependencyInjection(coreDependencyInjectionConfigurationEnumeration, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
}