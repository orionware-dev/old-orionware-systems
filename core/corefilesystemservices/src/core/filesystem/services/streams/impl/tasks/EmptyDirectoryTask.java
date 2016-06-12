package core.filesystem.services.streams.impl.tasks;

import java.io.File;
import org.apache.commons.io.FileUtils;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class EmptyDirectoryTask extends FileSystemObject implements FileSystemTask
{
    public static boolean run(File directory)
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


    public static boolean run(String directory)
    {
        return run(new File(directory));
    }
}