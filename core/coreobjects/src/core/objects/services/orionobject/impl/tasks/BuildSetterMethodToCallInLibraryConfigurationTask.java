package core.objects.services.orionobject.impl.tasks;

import core.OrionSimpleObject;
import core.services.OrionTask;

public class BuildSetterMethodToCallInLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public String run(String enumerationName)
    {
        String setterMethodToCallInLibraryConfiguration = "set";
        String[] enumerationNameTokens = enumerationName.split("_");
        
        for(String enumerationNameToken : enumerationNameTokens)
        {
            setterMethodToCallInLibraryConfiguration = new CreateSetterMethodToCallInLibraryConfigurationTask().run(enumerationNameToken, setterMethodToCallInLibraryConfiguration);
        }
        
        return setterMethodToCallInLibraryConfiguration;
    }
}