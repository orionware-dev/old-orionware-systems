package core.filesystem.tasks;

import java.io.Closeable;
import java.io.IOException;
import core.services.OrionTask;

public class CloseResourceTask implements OrionTask
{
    private Closeable closeable;
    
    
    public CloseResourceTask(Closeable closeable)
    {
        this.closeable = closeable;
    }
    

    @Override
    public Object execute(Object... methodParameters)
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

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}