package core.filesystem.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import core.services.OrionTask;

public class GetFileStreamTask implements OrionTask
{
    private String fileLocation;
    
    
    public GetFileStreamTask(String fileLocation)
    {
        this.fileLocation = fileLocation;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        try
        {
            return new FileInputStream(fileLocation);
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}