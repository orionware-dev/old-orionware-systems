package core.reflection.services.enumerations.impl;

import java.lang.reflect.InvocationTargetException;
import core.reflection.services.ReflectionServiceObject;
import core.reflection.services.enumerations.ReflectionEnumerationService;
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
        return enumerationClass.getEnumConstants();
    }


    @SuppressWarnings("rawtypes")
    @Override
    public String getEnumerationName(Enum enumerationDefinition)
    {
        return enumerationDefinition.name();
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public String getEnumerationValue(Class<Enum> enumerationClass, String enumerationName)
    {
        try
        {
            return (String)enumerationClass.getMethod("get", new Class<?>[]{})
                       .invoke(Enum.valueOf(enumerationClass, enumerationName), new Object[]{});
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}