package core.objects.services.orionobject.impl.tasks;

import core.OrionSimpleObject;
import core.services.OrionTask;

public class CreateSetterMethodToCallInLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public String run(String enumerationNameToken, String setterMethodToCallInLibraryConfiguration)
    {
        enumerationNameToken = enumerationNameToken.toLowerCase();
        char[] enumNameTokenCharactersArray = enumerationNameToken.toCharArray();
        enumNameTokenCharactersArray[0] = Character.toUpperCase(enumNameTokenCharactersArray[0]);
        return setterMethodToCallInLibraryConfiguration + String.copyValueOf(enumNameTokenCharactersArray);
    }
}