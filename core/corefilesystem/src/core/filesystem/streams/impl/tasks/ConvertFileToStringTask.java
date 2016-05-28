package core.filesystem.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;
import core.filesystem.streams.FileSystemStreamsService;

public class ConvertFileToStringTask extends FileSystemObject implements FileSystemTask
{
    private StringBuilder fileStringBuilder;
    private BufferedReader input;
    private String currentLine;
    
    
    public ConvertFileToStringTask()
    {
        this.fileStringBuilder = new StringBuilder();
    }
    
    
    public String run(FileSystemStreamsService fileSystemStreamsService, String filePath)
    {
        String fileString = null;
        this.input = (BufferedReader)fileSystemStreamsService.getReaderForFile(filePath);
        this.currentLine = null;
        
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
            fileSystemStreamsService.closeResource(input);
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