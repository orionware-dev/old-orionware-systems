package core.filesystem.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.services.OrionTask;

public class EmptyDirectoryTask implements OrionTask
{
    private String directory;
    
    
    public EmptyDirectoryTask(String directory)
    {
        this.directory = directory;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        try
        {
            FileUtils.cleanDirectory(new File(directory)); 
        }
        catch(Exception exception)
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