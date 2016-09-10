package core.utilities.services.strings.impl;

import core.utilities.services.strings.CoreStringsService;

public class CoreStringsServiceImpl implements CoreStringsService
{
    @Override
    public String convertFirstCharacterToUppercase(String aString)
    {
        char[] stringCharactersArray = aString.toCharArray();
        stringCharactersArray[0] = Character.toUpperCase(stringCharactersArray[0]);
        return String.copyValueOf(stringCharactersArray);
    }
}