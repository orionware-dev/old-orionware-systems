package core.reflection.tasks;

import java.lang.reflect.InvocationTargetException;
import core.services.OrionTask;

public class InstantiateClassTask implements OrionTask
{
    private Class<?> classToInstantiate;
    
    
    public InstantiateClassTask(Class<?> classToInstantiate)
    {
        this.classToInstantiate = classToInstantiate;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        try
        {
            return classToInstantiate.getConstructor().newInstance();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
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
        
        return null;
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}