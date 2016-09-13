package core.utilities.strings.impl;

import core.utilities.strings.CoreStringsService;

public class CoreStringsServiceImpl implements CoreStringsService
{
    @Override
    public String convertFirstCharacterToUppercase(String aString)
    {
        char[] stringCharactersArray = aString.toCharArray();
        stringCharactersArray[0] = Character.toUpperCase(stringCharactersArray[0]);
        return String.copyValueOf(stringCharactersArray);
    }


    @Override
    public String deleteLineSeparatorFromTheEnd(String aString)
    {
        if(aString.endsWith(System.lineSeparator()))
        {
            aString.substring(0, aString.length() - 2);
        }

        return aString;
    }


    @Override
    public StringBuilder deleteLineSeparatorFromTheEnd(StringBuilder stringBuilder)
    {
        String aString = stringBuilder.toString();

        if(aString.endsWith(System.lineSeparator()))
        {
            aString.substring(0, aString.length() - 2);
        }

        return new StringBuilder(aString);
    }
}