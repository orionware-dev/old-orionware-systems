package core.filesystem.tasks;

import java.io.Closeable;
import java.io.IOException;
import core.services.OrionTask;

public class CloseResourceTask implements OrionTask
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