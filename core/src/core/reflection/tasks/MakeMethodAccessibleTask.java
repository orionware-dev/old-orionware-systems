package core.reflection.tasks;

import java.lang.reflect.Method;
import core.services.OrionTask;

public class MakeMethodAccessibleTask implements OrionTask
{
    public void run(Method method)
    {
        if(!method.isAccessible())
        {
            method.setAccessible(true);
        }
    }
}