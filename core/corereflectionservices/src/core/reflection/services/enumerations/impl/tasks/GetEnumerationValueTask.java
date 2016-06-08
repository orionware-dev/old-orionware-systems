package core.reflection.services.enumerations.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;
import core.reflection.services.loader.ReflectionLoaderService;
import core.reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class GetEnumerationValueTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public String run(Class<Enum> enumerationClass, String enumerationName)
    {
        ReflectionLoaderService reflectionLoaderService = new ReflectionLoaderServiceImpl();
        
        try
        {
            return (String)reflectionLoaderService.callMethod(enumerationClass.getMethod("get", new Class<?>[]{}), enumerationClass, new Object[]{});
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