package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import core.services.OrionTask;

public class GetWriterForFileTask implements OrionTask
{
    public Object run(String filePath)
    {
        try
        {
            return new BufferedWriter(new FileWriter(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}