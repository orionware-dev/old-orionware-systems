package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class SaveStringToFileTask extends OrionTask
{
    private String lineSeparator;
    private BufferedWriter output = null;
    private int numberOfLines;
    private int lineCounter;
    private FileSystemService fileSystemService;
    
    
    public Object run(FileSystemService fileSystemService, String filePath, String fileString)
    {
        this.fileSystemService = fileSystemService;
        this.lineSeparator = System.lineSeparator();
        this.output = (BufferedWriter)fileSystemService.getWritterForFile(filePath);
        String[] lines = fileString.split(lineSeparator);
        this.numberOfLines = lines.length;
        this.lineCounter = 1;
        Arrays.stream(lines).forEach(this::writeLineToFile);
        return null;
    }
    
    
    private void writeLineToFile(String lineToWrite)
    {
        try
        {
            output.write(lineToWrite);
            
            if(lineCounter != numberOfLines)
            {
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
    }
}