package core.objects.orionobject.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.services.OrionTask;

public class SetEnumerationValueToLibraryConfigurationTask extends OrionSimpleObject implements OrionTask
{
    public void run(LibraryConfiguration libraryConfiguration, String setterMethodToCallInLibraryConfiguration, String enumerationValue)
    {
        try
        {
            libraryConfiguration.getClass().getMethod(setterMethodToCallInLibraryConfiguration, String.class)
                .invoke(libraryConfiguration, enumerationValue);
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
    }
}