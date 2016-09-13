package core.objects.orionobject.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import core.OrionSimpleObject;
import core.abstraction.ConfigurationEnumeration;
import core.services.OrionTask;

public class GetEnumerationValueTask extends OrionSimpleObject implements OrionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public String run(Class<ConfigurationEnumeration> libraryConfigurationEnumerationClass, Class<Enum> libraryConfigurationAbstractEnumerationClass, String enumerationName)
    {
        try
        {
            return (String)libraryConfigurationEnumerationClass.getMethod("get", new Class<?>[]{})
                       .invoke(Enum.valueOf((Class<Enum>)libraryConfigurationAbstractEnumerationClass, enumerationName), new Object[]{});
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