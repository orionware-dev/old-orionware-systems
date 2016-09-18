package filesystem.files.impl;

import java.io.BufferedReader;
import filesystem.FileSystemServiceObject;
import filesystem.files.FileService;
import filesystem.files.impl.tasks.ConvertFileToStringTask;
import filesystem.files.impl.tasks.SaveStringToFileTask;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class FileServiceImpl extends FileSystemServiceObject implements FileService
{
    @Override
    public String convertFileToString(String filePath)
    {
        return ConvertFileToStringTask.run((BufferedReader)new FileSystemStreamsServiceImpl().getReaderForFile(filePath));
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile)
    {
        return SaveStringToFileTask.run(filePath, fileString, addEmptyLineAtTheEndOfTheFile);
    }


    @Override
    public boolean saveStringToFile(String filePath, String fileString)
    {
        return SaveStringToFileTask.run(filePath, fileString);
    }
}