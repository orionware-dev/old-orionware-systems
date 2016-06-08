package core.reflection.services.enumerations.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;
import core.reflection.services.loader.ReflectionLoaderService;
import core.reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class GetEnumerationValueTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public static String run(Class<Enum> enumerationClass, String enumerationName)
    {
        ReflectionLoaderService reflectionLoaderService = new ReflectionLoaderServiceImpl();
        
        try
        {
            String enumerationValue = (String)reflectionLoaderService.callMethod(enumerationClass.getMethod("get", new Class<?>[]{}), enumerationClass, new Object[]{});
            
            if(enumerationValue == null)
            {
                enumerationValue = "";
            }
            
            return enumerationValue;
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