package core.reflection.tasks;

import core.services.OrionTask;

public class LoadClassTask implements OrionTask
{
    private String className;
    
    
    public LoadClassTask(String className)
    {
        this.className = className;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
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

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}