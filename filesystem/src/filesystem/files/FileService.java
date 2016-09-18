package filesystem.files;

import filesystem.FileSystemService;

public interface FileService extends FileSystemService
{
    public String convertFileToString(String filePath);


    public boolean saveStringToFile(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile);


    public boolean saveStringToFile(String filePath, String fileString);
}