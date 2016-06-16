package core.objects.services.orionobject.impl.tasks;

import core.OrionSimpleObject;
import core.configuration.CoreConfigurationConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class GetEnumerationValueAndSetItToLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    @SuppressWarnings("rawtypes")
    public void run(Class<CoreConfigurationConfigurationEnumeration> coreConfigurationEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = new GetEnumerationValueTask().run(coreConfigurationEnumerationClass, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
}