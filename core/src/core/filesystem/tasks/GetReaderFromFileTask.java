package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import core.services.OrionTask;

public class GetReaderFromFileTask implements OrionTask
{
    public Reader run(String filePath)
    {
        try
        {
            return new BufferedReader(new FileReader(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}