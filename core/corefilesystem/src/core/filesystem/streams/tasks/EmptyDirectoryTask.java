package core.filesystem.streams.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.OrionSimpleObject;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class EmptyDirectoryTask extends FileSystemObject implements FileSystemTask
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