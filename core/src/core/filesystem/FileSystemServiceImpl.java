package core.filesystem;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.tasks.CloseResourceTask;
import core.filesystem.tasks.ConvertFileToStringTask;
import core.filesystem.tasks.EmptyDirectoryTask;
import core.filesystem.tasks.GetFileStreamTask;
import core.filesystem.tasks.GetReaderFromFileTask;
import core.filesystem.tasks.GetWriterForFileTask;
import core.filesystem.tasks.SaveStringToFileTask;

public class FileSystemServiceImpl implements FileSystemService
{
    @Override
    public InputStream getFileStream(String fileLocation)
    {
        return (InputStream)new GetFileStreamTask(fileLocation).execute();
    }
    
    
    @Override
    public String convertFileToString(String filePath)
    {
        return (String)new ConvertFileToStringTask(this, filePath).execute();
    }


    @Override
    public void saveStringToFile(String filePath, String fileString)
    {
        new SaveStringToFileTask(this, filePath, fileString).execute();
    }
    
    
    @Override
    public void emptyDirectory(String directory)
    {
        new EmptyDirectoryTask(directory).execute();
    }
    
    
    @Override
    public void closeResource(Closeable closeable)
    {
        new CloseResourceTask(closeable).execute();
    }
    
    
    @Override
    public Reader getReaderFromFile(String filePath)
    {
        return (Reader)new GetReaderFromFileTask(filePath).execute();
    }
    
    
    @Override
    public Writer getWritterForFile(String filePath)
    {
        return (Writer)new GetWriterForFileTask(filePath).execute();
    }
}