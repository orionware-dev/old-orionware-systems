package core.objects.orionobject.impl.tasks;

import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.abstraction.ConfigurationEnumeration;
import core.services.OrionTask;

public class GetEnumerationValueAndSetItToLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    private SetEnumerationValueToLibraryConfigurationTask setEnumerationValueToLibraryConfigurationTask = new SetEnumerationValueToLibraryConfigurationTask();
    
    
    @SuppressWarnings("rawtypes")
    public void run(Class<ConfigurationEnumeration> libraryConfigurationEnumerationClass, Class<Enum> libraryConfigurationAbstractEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = BuildSetterMethodToCallInLibraryConfigurationTask.run(enumerationName);
        String enumerationValue = GetEnumerationValueTask.run(libraryConfigurationEnumerationClass, libraryConfigurationAbstractEnumerationClass, enumerationName);
        setEnumerationValueToLibraryConfigurationTask.run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
}