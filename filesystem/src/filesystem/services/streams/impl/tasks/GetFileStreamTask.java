package filesystem.services.streams.impl.tasks;

import java.io.InputStream;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class GetFileStreamTask extends FileSystemObject implements FileSystemTask
{
    public InputStream run(String filePath)
    {
        return this.getClass().getResourceAsStream(filePath);
    }
}