package filesystem.streams.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import filesystem.FileSystemServiceObject;
import filesystem.streams.FileSystemStreamsService;
import filesystem.streams.impl.tasks.CloseResourceTask;
import filesystem.streams.impl.tasks.ConvertFileToStringTask;
import filesystem.streams.impl.tasks.EmptyDirectoryTask;
import filesystem.streams.impl.tasks.GetFileStreamTask;
import filesystem.streams.impl.tasks.GetReaderFromFileTask;
import filesystem.streams.impl.tasks.GetWriterForFileTask;
import filesystem.streams.impl.tasks.SaveStringToFileTask;

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
        return new ConvertFileToStringTask().run((BufferedReader)getReaderForFile(filePath));
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile)
    {
        return new SaveStringToFileTask().run(filePath, fileString, addEmptyLineAtTheEndOfTheFile);
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString)
    {
        return new SaveStringToFileTask().run(filePath, fileString);
    }


    @Override
    public void emptyDirectory(File directory)
    {
        new EmptyDirectoryTask().run(directory);
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
    public Reader getReaderForFile(String filePath)
    {
        return new GetReaderFromFileTask().run(filePath);
    }


    @Override
    public Writer getWritterForFile(String filePath)
    {
        return new GetWriterForFileTask().run(filePath);
    }
}