package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import core.services.OrionTask;

public class GetWriterForFileTask extends OrionTask
{
    public Object execute(String filePath)
    {
        BufferedWriter output = null;
        
        try
        {
            output = new BufferedWriter(new FileWriter(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        
        return output;
    }
}