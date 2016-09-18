package filesystem.streams.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import filesystem.FileSystemServiceObject;
import filesystem.streams.FileSystemStreamsService;
import filesystem.streams.impl.tasks.CloseResourceTask;
import filesystem.streams.impl.tasks.GetFileStreamTask;
import filesystem.streams.impl.tasks.GetReaderFromFileTask;
import filesystem.streams.impl.tasks.GetWriterForFileTask;

public class FileSystemStreamsServiceImpl extends FileSystemServiceObject implements FileSystemStreamsService
{
    @Override
    public InputStream getFileStream(String filePath)
    {
        return GetFileStreamTask.run(filePath);
    }


    @Override
    public void closeResource(Closeable closeable)
    {
        CloseResourceTask.run(closeable);
    }


    @Override
    public Reader getReaderForFile(String filePath)
    {
        return GetReaderFromFileTask.run(filePath);
    }


    @Override
    public Writer getWritterForFile(String filePath)
    {
        return GetWriterForFileTask.run(filePath);
    }
}