package reflection.services.accessibleobjects.classes.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

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