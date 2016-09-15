package filesystem.streams.impl.tasks;

import java.io.InputStream;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class GetFileStreamTask extends FileSystemObject implements FileSystemTask
{
    public static InputStream run(String filePath)
    {
        return new GetFileStreamTask().getClass().getResourceAsStream(filePath);
    }
}