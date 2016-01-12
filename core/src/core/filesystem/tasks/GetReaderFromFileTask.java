package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import core.services.OrionTask;

public class GetReaderFromFileTask implements OrionTask
{
    private String filePath;
    
    
    public GetReaderFromFileTask(String filePath)
    {
        this.filePath = filePath;
    }
    

    @Override
    public Object execute(Object... methodParameters)
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

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}