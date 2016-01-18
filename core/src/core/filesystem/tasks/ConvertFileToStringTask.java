package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class ConvertFileToStringTask implements OrionTask
{
    public String run(FileSystemService fileSystemService, String filePath)
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
}