package filesystem.streams.impl.tasks;

import java.io.Closeable;
import java.io.IOException;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class CloseResourceTask extends FileSystemObject implements FileSystemTask
{
    public static boolean run(Closeable closeable)
    {
        if(closeable != null)
        {
            return closeResource(closeable);
        }

        return false;
    }


    private static boolean closeResource(Closeable closeable)
    {
        try
        {
            closeable.close();
            return true;
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }

        return false;
    }
}