package core.filesystem.streams.tasks;

import java.io.Closeable;
import java.io.IOException;
import core.OrionSimpleObject;
import core.filesystem.OrionFileSystemTask;

public class CloseResourceTask extends OrionSimpleObject implements OrionFileSystemTask
{
    public boolean run(Closeable closeable)
    {
        if(closeable != null)
        {
            return closeResource(closeable);
        }
        
        return false;
    }
    
    
    private boolean closeResource(Closeable closeable)
    {
        try
        {
            closeable.close();
            return true;
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
            return false;
        }
    }
}