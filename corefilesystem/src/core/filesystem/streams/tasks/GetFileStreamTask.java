package core.filesystem.streams.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import core.filesystem.OrionFileSystemTask;

public class GetFileStreamTask implements OrionFileSystemTask
{
    public InputStream run(String filePath)
    {
        try
        {
            return new FileInputStream(filePath);
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}