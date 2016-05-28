package core.filesystem.streams.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.FileSystemObject;
import core.filesystem.streams.FileSystemStreamsService;
import core.filesystem.streams.impl.tasks.CloseResourceTask;
import core.filesystem.streams.impl.tasks.ConvertFileToStringTask;
import core.filesystem.streams.impl.tasks.EmptyDirectoryTask;
import core.filesystem.streams.impl.tasks.GetFileStreamTask;
import core.filesystem.streams.impl.tasks.GetReaderFromFileTask;
import core.filesystem.streams.impl.tasks.GetWriterForFileTask;
import core.filesystem.streams.impl.tasks.SaveStringToFileTask;

public class FileSystemStreamsServiceImpl extends FileSystemObject implements FileSystemStreamsService
{
    private GetFileStreamTask getFileStreamTask;
    private ConvertFileToStringTask convertFileToStringTask;
    private SaveStringToFileTask saveStringToFileTask;
    private EmptyDirectoryTask emptyDirectoryTask;
    private CloseResourceTask closeResourceTask;
    private GetReaderFromFileTask getReaderFromFileTask;
    private GetWriterForFileTask getWriterForFileTask;
    
    
    public FileSystemStreamsServiceImpl()
    {
        this.getFileStreamTask = new GetFileStreamTask();
        this.convertFileToStringTask = new ConvertFileToStringTask();
        this.saveStringToFileTask = new SaveStringToFileTask();
        this.emptyDirectoryTask = new EmptyDirectoryTask();
        this.closeResourceTask = new CloseResourceTask();
        this.getReaderFromFileTask = new GetReaderFromFileTask();
        this.getWriterForFileTask = new GetWriterForFileTask();
    }
    
    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return getFileStreamTask.run(filePath);
    }
    
    
    @Override
    public String convertFileToString(String filePath)
    {
        return convertFileToStringTask.run(this, filePath);
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString)
    {
        return saveStringToFileTask.run(this, filePath, fileString);
    }
    
    
    @Override
    public void emptyDirectory(String directory)
    {
        emptyDirectoryTask.run(directory);
    }
    
    
    @Override
    public void closeResource(Closeable closeable)
    {
        closeResourceTask.run(closeable);
    }
    
    
    @Override
    public Reader getReaderForFile(String filePath)
    {
        return getReaderFromFileTask.run(filePath);
    }
    
    
    @Override
    public Writer getWritterForFile(String filePath)
    {
        return getWriterForFileTask.run(filePath);
    }
}