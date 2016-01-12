package core.reflection.tasks;

import java.lang.reflect.Method;
import core.services.OrionTask;

public class MakeMethodAccessibleTask implements OrionTask
{
    private Method method;
    
    
    public MakeMethodAccessibleTask(Method method)
    {
        this.method = method;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        if(!method.isAccessible())
        {
            method.setAccessible(true);
        }
        
        return null;
    }


    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}