package core.reflection.services.loader.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class LoadClassTask extends ReflectionObject implements ReflectionTask
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