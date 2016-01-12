package core.filesystem.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemService;
import core.services.OrionTask;

public class SaveStringToFileTask extends OrionTask
{
    public Object run(FileSystemService fileSystemService, String filePath, String fileString)
    {
        BufferedWriter output = null;
        String lineSeparator = System.lineSeparator();
        
        try
        {
            output = (BufferedWriter)fileSystemService.getWritterForFile(filePath);
            String[] lines = fileString.split(lineSeparator);
            int numberOfLines = lines.length;
            int lineCounter = 1;
            
            for(String line : lines)
            {
                output.write(line);
                
                if(lineCounter != numberOfLines)
                {
                    output.write(lineSeparator);
                }
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
}