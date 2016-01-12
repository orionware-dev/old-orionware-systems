package core.filesystem.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import core.services.OrionTask;

public class GetFileStreamTask extends OrionTask
{
    public Object execute(String filePath)
    {
        try
        {
            return new FileInputStream(filePath);
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}