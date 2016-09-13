package core.objects.orionobject.impl.tasks;

import core.OrionSimpleObject;
import core.services.OrionTask;
import core.utilities.strings.CoreStringsService;
import core.utilities.strings.impl.CoreStringsServiceImpl;

public class BuildSetterMethodToCallInLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    private static String SETTER_METHOD_PREFIX = "set";
    
    
    public String run(String enumerationName)
    {
        String setterMethodToCallInLibraryConfiguration = SETTER_METHOD_PREFIX;
        CoreStringsService coreStringsService = new CoreStringsServiceImpl();
        String[] enumerationNameTokens = enumerationName.split("_");

        for(String enumerationNameToken : enumerationNameTokens)
        {            
            enumerationNameToken = enumerationNameToken.toLowerCase();
            setterMethodToCallInLibraryConfiguration += coreStringsService.convertFirstCharacterToUppercase(enumerationNameToken);
        }

        return setterMethodToCallInLibraryConfiguration;
    }
}