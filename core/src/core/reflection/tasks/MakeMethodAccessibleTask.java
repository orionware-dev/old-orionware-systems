package core.reflection.tasks;

import java.lang.reflect.Method;
import core.services.OrionTask;

public class MakeMethodAccessibleTask implements OrionTask
{
    public void run(Method method)
    {
        if(methodIsNotAccessible(method))
        {
            makeMethodAccessible(method);
        }
    }
    
    
    private boolean methodIsNotAccessible(Method method)
    {
        return !method.isAccessible();
    }
    
    
    private void makeMethodAccessible(Method method)
    {
        method.setAccessible(true);
    }
}