package core.filesystem.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class ConvertFileToStringTask implements OrionTask
{
    private StringBuilder fileStringBuilder = new StringBuilder();
    private BufferedReader input;
    private String currentLine;
    
    
    public String run(FileSystemService fileSystemService, String filePath)
    {
        String fileString = null;
        input = (BufferedReader)fileSystemService.getReaderForFile(filePath);
        currentLine = null;
        
        try
        {
            do
            {
                addLineToFile();
            }
            while(currentLine != null);
        }
        finally
        {
            fileSystemService.closeResource(input);
        }
        
        fileString = fileStringBuilder.toString();
        return fileString;
    }
    
    
    private void addLineToFile()
    {
        try
        {
            currentLine = input.readLine();
            fileStringBuilder.append(currentLine);
            fileStringBuilder.append(System.lineSeparator());
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}