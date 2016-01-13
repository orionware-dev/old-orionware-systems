package core.filesystem.tasks;

import java.io.Closeable;
import java.io.IOException;
import core.services.OrionTask;

public class CloseResourceTask implements OrionTask
{
    public Object run(Closeable closeable)
    {
        if(closeable != null)
        {
            try
            {
                closeable.close();
            }
            catch(IOException exception)
            {
                exception.printStackTrace();
            }
        }
        
        return null;
    }
}