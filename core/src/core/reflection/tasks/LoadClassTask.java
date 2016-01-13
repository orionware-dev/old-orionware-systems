package core.reflection.tasks;

import core.services.OrionTask;

public class LoadClassTask implements OrionTask
{
    public Object run(String className)
    {
        try
        {
            return ClassLoader.getSystemClassLoader().loadClass(className);
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}