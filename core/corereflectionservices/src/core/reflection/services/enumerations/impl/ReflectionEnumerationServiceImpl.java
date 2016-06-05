package core.reflection.services.enumerations.impl;

import core.reflection.services.ReflectionServiceObject;
import core.reflection.services.enumerations.ReflectionEnumerationService;
import core.reflection.services.enumerations.impl.tasks.GetEnumerationDefinitionsTask;
import core.reflection.services.enumerations.impl.tasks.GetEnumerationNameTask;
import core.reflection.services.enumerations.impl.tasks.GetEnumerationValueTask;
import core.reflection.services.enumerations.impl.tasks.InstantiateEnumerationTask;

public class ReflectionEnumerationServiceImpl extends ReflectionServiceObject implements ReflectionEnumerationService
{
    @SuppressWarnings({"rawtypes"})
    @Override
    public Class<Enum> instantiateEnumeration(String enumerationPath)
    {
        return new InstantiateEnumerationTask().run(enumerationPath);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Enum[] getEnumerationDefinitions(Class<Enum> enumerationClass)
    {
        return new GetEnumerationDefinitionsTask().run(enumerationClass);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public String getEnumerationName(Enum enumerationDefinition)
    {
        return new GetEnumerationNameTask().run(enumerationDefinition);
    }


    @SuppressWarnings({"rawtypes"})
    @Override
    public String getEnumerationValue(Class<Enum> enumerationClass, String enumerationName)
    {
        return new GetEnumerationValueTask().run(enumerationClass, enumerationName);
    }
}