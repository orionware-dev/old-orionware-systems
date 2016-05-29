package core.reflection.facades.enumerations;

import core.reflection.ReflectionFacade;

public interface ReflectionEnumerationFacade extends ReflectionFacade
{
    @SuppressWarnings("rawtypes")
    public Class<Enum> instantiateEnumeration(String enumerationPath);
    
    
    @SuppressWarnings("rawtypes")
    public Enum[] getEnumerationDefinitions(Class<Enum> enumerationClass);
    
    
    @SuppressWarnings("rawtypes")
    public String getEnumerationName(Enum enumDefinition);
    
    
    @SuppressWarnings("rawtypes")
    public String getEnumerationValue(Class<Enum> enumerationClass, String enumName);
}