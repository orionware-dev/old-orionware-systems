package filesystem.streams.impl.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class EmptyDirectoryTask extends FileSystemObject implements FileSystemTask
{
    public boolean run(File directory)
    {
        try
        {
            FileUtils.cleanDirectory(directory);
            return true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return false;
    }


    public boolean run(String directory)
    {
        return run(new File(directory));
    }
}