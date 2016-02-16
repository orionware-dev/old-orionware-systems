package core.filesystem.streams.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.OrionSimpleObject;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;
import core.filesystem.streams.FileSystemService;

public class ConvertFileToStringTask extends FileSystemObject implements FileSystemTask
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