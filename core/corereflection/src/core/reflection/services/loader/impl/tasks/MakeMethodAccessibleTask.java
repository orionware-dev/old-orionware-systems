package core.reflection.services.loader.impl.tasks;

import java.lang.reflect.Method;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class MakeMethodAccessibleTask extends ReflectionObject implements ReflectionTask
{
    private Method method;


    public void run(Method method)
    {
        this.method = method;

        if(methodIsNotAccessible())
        {
            makeMethodAccessible();
        }
    }


    private boolean methodIsNotAccessible()
    {
        return !method.isAccessible();
    }


    private void makeMethodAccessible()
    {
        method.setAccessible(true);
    }
}