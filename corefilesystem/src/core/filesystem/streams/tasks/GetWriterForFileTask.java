package core.filesystem.streams.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import core.filesystem.OrionFileSystemTask;

public class GetWriterForFileTask implements OrionFileSystemTask
{
    public Writer run(String filePath)
    {
        try
        {
            return new BufferedWriter(new FileWriter(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}