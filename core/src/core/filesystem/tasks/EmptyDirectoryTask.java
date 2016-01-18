package core.filesystem.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.services.OrionTask;

public class EmptyDirectoryTask implements OrionTask
{
    public boolean run(String directory)
    {
        try
        {
            FileUtils.cleanDirectory(new File(directory));
            return true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return false;
    }
}