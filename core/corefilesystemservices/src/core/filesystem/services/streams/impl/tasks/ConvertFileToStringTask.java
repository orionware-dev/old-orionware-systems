package core.filesystem.services.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class ConvertFileToStringTask extends FileSystemObject implements FileSystemTask
{
    private StringBuilder fileStringBuilder;
    private BufferedReader input;
    private String currentLine;
    
    
    public ConvertFileToStringTask()
    {
        this.fileStringBuilder = new StringBuilder();
        this.currentLine = null;
    }
    
    
    public String run(String filePath, BufferedReader input)
    {
        String fileString = null;
        this.input = input;
        
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
            CloseResourceTask.run(input);
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