package core.filesystem.services.streams.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.services.FileSystemServiceObject;
import core.filesystem.services.streams.FileSystemStreamsService;
import core.filesystem.services.streams.impl.tasks.CloseResourceTask;
import core.filesystem.services.streams.impl.tasks.ConvertFileToStringTask;
import core.filesystem.services.streams.impl.tasks.EmptyDirectoryTask;
import core.filesystem.services.streams.impl.tasks.GetFileStreamTask;
import core.filesystem.services.streams.impl.tasks.GetReaderFromFileTask;
import core.filesystem.services.streams.impl.tasks.GetWriterForFileTask;
import core.filesystem.services.streams.impl.tasks.SaveStringToFileTask;

public class FileSystemStreamsServiceImpl extends FileSystemServiceObject implements FileSystemStreamsService
{
    @Override
    public InputStream getFileStream(String filePath)
    {
        return new GetFileStreamTask().run(filePath);
    }
    
    
    @Override
    public String convertFileToString(String filePath)
    {
        return new ConvertFileToStringTask().run(filePath, (BufferedReader)getReaderForFile(filePath));
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString)
    {
        return new SaveStringToFileTask().run(this, filePath, fileString);
    }
    
    
    @Override
    public void emptyDirectory(File directory)
    {
        EmptyDirectoryTask.run(directory);
    }
    
    
    @Override
    public void emptyDirectory(String directory)
    {
        EmptyDirectoryTask.run(directory);
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