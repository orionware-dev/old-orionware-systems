package filesystem.streams.impl.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class GetWriterForFileTask extends FileSystemObject implements FileSystemTask
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