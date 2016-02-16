package core.filesystem.streams.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import core.OrionSimpleObject;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class GetFileStreamTask extends FileSystemObject implements FileSystemTask
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