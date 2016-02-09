package core.reflection.loader.tasks;

import core.reflection.OrionReflectionTask;

public class LoadClassTask implements OrionReflectionTask
{
    public Class<?> run(String className)
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