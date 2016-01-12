package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class SaveStringToFileTask implements OrionTask
{
    private FileSystemService fileSystemService;
    private String filePath;
    private String fileString;
    
    
    public SaveStringToFileTask(FileSystemService fileSystemService, String filePath, String fileString)
    {
        this.fileSystemService = fileSystemService;
        this.filePath = filePath;
        this.fileString = fileString;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        BufferedWriter output = null;
        String lineSeparator = System.lineSeparator();
        
        try
        {
            output = (BufferedWriter)fileSystemService.getWritterForFile(filePath);
            String[] lines = fileString.split(lineSeparator);
            
            for(String line : lines)
            {
                output.write(line);
                output.write(lineSeparator);
            }
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            fileSystemService.closeResource(output);
        }
        
        return null;
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}