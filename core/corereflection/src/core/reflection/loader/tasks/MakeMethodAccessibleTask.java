package core.reflection.loader.tasks;

import java.lang.reflect.Method;
import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class MakeMethodAccessibleTask extends OrionSimpleObject implements OrionReflectionTask
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