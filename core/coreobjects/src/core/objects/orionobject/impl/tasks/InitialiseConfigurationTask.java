package core.objects.orionobject.impl.tasks;

import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.abstraction.ConfigurationEnumeration;
import core.services.OrionTask;

public class InitialiseConfigurationTask extends OrionSimpleObject implements OrionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public LibraryConfiguration run(String libraryConfigurationEnumerationClassPath, Enum[] configurationEnumerationValues)
    {
        GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        
        try
        {
            Class<ConfigurationEnumeration> temp = (Class<ConfigurationEnumeration>)Class.forName(libraryConfigurationEnumerationClassPath);
            Class<Enum> temp1 = (Class<Enum>)Class.forName(libraryConfigurationEnumerationClassPath);
            
            for(Enum configurationEnumerationValue : configurationEnumerationValues)
            {
                getEnumerationValueAndSetItToLibraryConfigurationTask.run(temp, temp1, configurationEnumerationValue, libraryConfiguration);
            }
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return libraryConfiguration;
    }
}