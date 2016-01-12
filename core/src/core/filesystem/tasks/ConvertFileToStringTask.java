package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class ConvertFileToStringTask implements OrionTask
{
    private String filePath;
    private FileSystemService fileSystemService;
    
    
    public ConvertFileToStringTask(FileSystemService fileSystemService, String filePath)
    {
        this.fileSystemService = fileSystemService;
        this.filePath = filePath;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        String fileString = null;
        BufferedReader input = null;
        
        try
        {
            input = (BufferedReader)fileSystemService.getReaderFromFile(filePath);
            StringBuilder fileStringBuilder = new StringBuilder();
            String currentLine = null;
            
            do
            {
                currentLine = input.readLine();
                fileStringBuilder.append(currentLine);
                fileStringBuilder.append(System.lineSeparator());
            }
            while(currentLine != null);
            
            fileString = fileStringBuilder.toString();
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
            fileSystemService.closeResource(input);
        }
        
        return fileString;
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}