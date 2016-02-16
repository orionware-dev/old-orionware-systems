package core.reflection.loader.tasks;

import java.lang.reflect.Method;
import core.OrionSimpleObject;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class MakeMethodAccessibleTask extends ReflectionObject implements ReflectionTask
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