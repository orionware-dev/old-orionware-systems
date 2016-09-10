package reflection.services.enumerations.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.impl.ReflectionAccessibleObjectsServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class GetEnumerationValueTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public String run(Class<Enum> enumerationClass, String enumerationName)
    {
        ReflectionMethodsService reflectionMethodsService = new ReflectionMethodsServiceImpl();

        try
        {
            String enumerationValue = (String)reflectionMethodsService.callMethod(enumerationClass.getMethod("get", new Class<?>[]{}), enumerationClass, new Object[]{});

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