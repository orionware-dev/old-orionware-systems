package core.reflection.loader.tasks;

import core.OrionSimpleObject;
import core.reflection.OrionReflectionTask;

public class LoadClassTask extends OrionSimpleObject implements OrionReflectionTask
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