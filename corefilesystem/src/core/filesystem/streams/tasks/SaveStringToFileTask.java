package core.filesystem.streams.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import core.filesystem.OrionFileSystemTask;
import core.filesystem.streams.FileSystemService;

public class SaveStringToFileTask implements OrionFileSystemTask
{
    private String lineSeparator = System.lineSeparator();
    private BufferedWriter output = null;
    private int numberOfLines;
    private int lineCounter;
    private boolean error = false;
    
    
    public boolean run(FileSystemService fileSystemService, String filePath, String fileString)
    {
        this.output = (BufferedWriter)fileSystemService.getWritterForFile(filePath);
        String[] lines = fileString.split(lineSeparator);
        this.numberOfLines = lines.length;
        this.lineCounter = 1;
        
        try
        {
            Arrays.stream(lines).forEach(this::writeLineToFile);
        }
        finally
        {
            fileSystemService.closeResource(output);
        }
        
        return error;
    }
    
    
    private void writeLineToFile(String lineToWrite)
    {
        try
        {
            output.write(lineToWrite);
            
            //we avoid an empty line at the end of the file
            if(lineCounter != numberOfLines)
            {
                output.write(lineSeparator);
            }
        }
        catch(FileNotFoundException exception)
        {
            error = true;
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            error = true;
            exception.printStackTrace();
        }
    }
}