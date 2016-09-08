package core.filesystem.facades.streams.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.facades.FileSystemFacadeObject;
import core.filesystem.facades.streams.FileSystemStreamsFacade;
import core.filesystem.services.streams.FileSystemStreamsService;
import core.filesystem.services.streams.impl.FileSystemStreamsServiceImpl;

public class FileSystemStreamsFacadeImpl extends FileSystemFacadeObject implements FileSystemStreamsFacade
{
    private FileSystemStreamsService fileSystemStreamsService;


    public FileSystemStreamsFacadeImpl()
    {
        this.fileSystemStreamsService = new FileSystemStreamsServiceImpl();
    }


    @Override
    public InputStream getFileStream(String fileLocation)
    {
        return fileSystemStreamsService.getFileStream(fileLocation);
    }


    @Override
    public String convertFileToString(String filePath)
    {
        return fileSystemStreamsService.convertFileToString(filePath);
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString)
    {
        return fileSystemStreamsService.saveStringToFile(filePath, fileString);
    }


    @Override
    public void emptyDirectory(String directory)
    {
        fileSystemStreamsService.emptyDirectory(directory);
    }


    @Override
    public void closeResource(Closeable stream)
    {
        fileSystemStreamsService.closeResource(stream);
    }


    @Override
    public Reader getReaderForFile(String filePath)
    {
        return fileSystemStreamsService.getReaderForFile(filePath);
    }


    @Override
    public Writer getWritterForFile(String filePath)
    {
        return fileSystemStreamsService.getWritterForFile(filePath);
    }
}