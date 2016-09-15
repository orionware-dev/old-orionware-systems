package reflection.constructors.retrieval.impl.tasks;

import java.lang.reflect.Constructor;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredConstructorTask extends ReflectionObject implements ReflectionTask
{
    public static Constructor<?> run(Object object, Class<?>... constructorParameterTypes)
    {
        return run(object.getClass(), constructorParameterTypes);
    }
    
    
    public static Constructor<?> run(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        try
        {
            if(constructorParameterTypes.length == 0)
            {
                constructorParameterTypes = new Class<?>[]{Object.class};
            }
            
            return aClass.getDeclaredConstructor(constructorParameterTypes);
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