package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import core.services.OrionTask;

public class GetWriterForFileTask implements OrionTask
{
    private String filePath;
    
    
    public GetWriterForFileTask(String filePath)
    {
        this.filePath = filePath;
    }
    

    @Override
    public Object execute(Object... methodParameters)
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

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}