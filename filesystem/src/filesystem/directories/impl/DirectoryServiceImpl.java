package filesystem.directories.impl;

import java.io.File;
import filesystem.FileSystemServiceObject;
import filesystem.directories.DirectoryService;
import filesystem.directories.impl.tasks.EmptyDirectoryTask;

public class DirectoryServiceImpl extends FileSystemServiceObject implements DirectoryService
{
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
}