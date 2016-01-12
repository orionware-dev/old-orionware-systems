package core.reflection.tasks;

import core.services.OrionTask;

public class LoadClassTask extends OrionTask
{
    public Object execute(String className)
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