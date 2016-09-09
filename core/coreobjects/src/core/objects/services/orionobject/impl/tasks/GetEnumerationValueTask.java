package core.objects.services.orionobject.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import core.OrionSimpleObject;
import configuration.CoreConfigurationConfigurationEnumeration;
import dependencyinjection.configuration.DependencyInjectionConfigurationEnumeration;
import core.services.OrionTask;

public class GetEnumerationValueTask extends OrionSimpleObject implements OrionTask
{
    public String runCore(Class<CoreConfigurationConfigurationEnumeration> coreConfigurationEnumerationClass, String enumerationName)
    {
        try
        {
            return (String)coreConfigurationEnumerationClass.getMethod("get", new Class<?>[]{}).invoke(Enum.valueOf(coreConfigurationEnumerationClass, enumerationName), new Object[]{});
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
    
    
    public String runDependencyInjection(Class<DependencyInjectionConfigurationEnumeration> dependencyInjectionConfigurationEnumeration, String enumerationName)
    {
        try
        {
            return (String)dependencyInjectionConfigurationEnumeration.getMethod("get", new Class<?>[]{}).invoke(Enum.valueOf(dependencyInjectionConfigurationEnumeration, enumerationName), new Object[]{});
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