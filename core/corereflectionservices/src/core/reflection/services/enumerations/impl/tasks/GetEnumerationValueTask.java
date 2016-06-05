package core.reflection.services.enumerations.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetEnumerationValueTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public String run(Class<Enum> enumerationClass, String enumerationName)
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