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
    public InputStream getFileStream(String filePath)
    {
        return (InputStream)new GetFileStreamTask().run(filePath);
    }
    
    
    @Override
    public String convertFileToString(String filePath)
    {
        return (String)new ConvertFileToStringTask().run(this, filePath);
    }


    @Override
    public void saveStringToFile(String filePath, String fileString)
    {
        new SaveStringToFileTask().run(this, filePath, fileString);
    }
    
    
    @Override
    public void emptyDirectory(String directory)
    {
        new EmptyDirectoryTask().run(directory);
    }
    
    
    @Override
    public void closeResource(Closeable closeable)
    {
        new CloseResourceTask().run(closeable);
    }
    
    
    @Override
    public Reader getReaderFromFile(String filePath)
    {
        return (Reader)new GetReaderFromFileTask().run(filePath);
    }
    
    
    @Override
    public Writer getWritterForFile(String filePath)
    {
        return (Writer)new GetWriterForFileTask().run(filePath);
    }
}