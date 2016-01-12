package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import core.services.OrionTask;

public class GetReaderFromFileTask extends OrionTask
{
    public Object run(String filePath)
    {
        BufferedReader input = null;
        
        try
        {
            input = new BufferedReader(new FileReader(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return input;
    }
}