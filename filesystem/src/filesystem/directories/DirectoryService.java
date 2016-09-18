package filesystem.directories;

import java.io.File;
import filesystem.FileSystemService;

public interface DirectoryService extends FileSystemService
{
    public void emptyDirectory(File directory);


    public void emptyDirectory(String directory);
}