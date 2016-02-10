package core.filesystem.streams.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.filesystem.OrionFileSystemTask;

public class EmptyDirectoryTask implements OrionFileSystemTask
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