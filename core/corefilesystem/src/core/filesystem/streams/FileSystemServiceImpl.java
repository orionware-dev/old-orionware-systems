package core.filesystem.streams;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.FileSystemObject;
import core.filesystem.streams.tasks.CloseResourceTask;
import core.filesystem.streams.tasks.ConvertFileToStringTask;
import core.filesystem.streams.tasks.EmptyDirectoryTask;
import core.filesystem.streams.tasks.GetFileStreamTask;
import core.filesystem.streams.tasks.GetReaderFromFileTask;
import core.filesystem.streams.tasks.GetWriterForFileTask;
import core.filesystem.streams.tasks.SaveStringToFileTask;

public class FileSystemServiceImpl extends FileSystemObject implements FileSystemService
{
    private GetFileStreamTask getFileStreamTask = new GetFileStreamTask();
    private ConvertFileToStringTask convertFileToStringTask = new ConvertFileToStringTask();
    private SaveStringToFileTask saveStringToFileTask = new SaveStringToFileTask();
    private EmptyDirectoryTask emptyDirectoryTask = new EmptyDirectoryTask();
    private CloseResourceTask closeResourceTask = new CloseResourceTask();
    private GetReaderFromFileTask getReaderFromFileTask = new GetReaderFromFileTask();
    private GetWriterForFileTask getWriterForFileTask = new GetWriterForFileTask();
    
    
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