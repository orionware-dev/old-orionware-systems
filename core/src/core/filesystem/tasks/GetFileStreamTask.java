package core.filesystem.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import core.services.OrionTask;

public class GetFileStreamTask implements OrionTask
{
    public InputStream run(String filePath)
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