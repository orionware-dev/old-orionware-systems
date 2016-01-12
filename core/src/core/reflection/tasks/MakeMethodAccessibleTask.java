package core.reflection.tasks;

import java.lang.reflect.Method;
import core.services.OrionTask;

public class MakeMethodAccessibleTask extends OrionTask
{
    public Object execute(Method method)
    {
        if(!method.isAccessible())
        {
            method.setAccessible(true);
        }
        
        return null;
    }
}