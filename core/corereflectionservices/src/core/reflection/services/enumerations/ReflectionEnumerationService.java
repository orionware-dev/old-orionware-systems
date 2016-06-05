package core.reflection.services.enumerations;

import core.reflection.ReflectionService;

public interface ReflectionEnumerationService extends ReflectionService
{
    @SuppressWarnings("rawtypes")
    public Class<Enum> instantiateEnumeration(String enumerationPath);
    
    
    @SuppressWarnings("rawtypes")
    public Enum[] getEnumerationDefinitions(Class<Enum> enumerationClass);
    
    
    @SuppressWarnings("rawtypes")
    public String getEnumerationName(Enum enumerationDefinition);
    
    
    @SuppressWarnings("rawtypes")
    public String getEnumerationValue(Class<Enum> enumerationClass, String enumerationName);
}