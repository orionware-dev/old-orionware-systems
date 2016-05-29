package core.reflection.facades.enumerations.impl;

import core.reflection.facades.ReflectionFacadeObject;
import core.reflection.facades.enumerations.ReflectionEnumerationFacade;
import core.reflection.services.enumerations.ReflectionEnumerationService;
import core.reflection.services.enumerations.impl.ReflectionEnumerationServiceImpl;

public class ReflectionEnumerationFacadeImpl extends ReflectionFacadeObject implements ReflectionEnumerationFacade
{
    private ReflectionEnumerationService reflectionEnumerationService;
    
    
    public ReflectionEnumerationFacadeImpl()
    {
        this.reflectionEnumerationService = new ReflectionEnumerationServiceImpl();
    }
    
    
    @SuppressWarnings({"rawtypes"})
    @Override
    public Class<Enum> instantiateEnumeration(String enumerationPath)
    {
        return reflectionEnumerationService.instantiateEnumeration(enumerationPath);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Enum[] getEnumerationDefinitions(Class<Enum> enumerationClass)
    {
        return reflectionEnumerationService.getEnumerationDefinitions(enumerationClass);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public String getEnumerationName(Enum enumDefinition)
    {
        return reflectionEnumerationService.getEnumerationName(enumDefinition);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public String getEnumerationValue(Class<Enum> enumerationClass, String enumName)
    {
        return reflectionEnumerationService.getEnumerationValue(enumerationClass, enumName);
    }
}