package core.filesystem.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.services.OrionTask;

public class EmptyDirectoryTask extends OrionTask
{
    public Object execute(String directory)
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
}