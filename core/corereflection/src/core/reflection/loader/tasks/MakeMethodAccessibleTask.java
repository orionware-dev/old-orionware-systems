package core.reflection.loader.tasks;

import java.lang.reflect.Method;
import core.reflection.OrionReflectionTask;

public class MakeMethodAccessibleTask implements OrionReflectionTask
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