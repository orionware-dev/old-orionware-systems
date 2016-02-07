package core.annotations.loader;

import java.io.InputStream;
import core.annotations.loader.filestream.GetAnnotationsFileStreamCoordinator;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private GetAnnotationsFileStreamCoordinator getAnnotationsFileStreamCoordinator = new GetAnnotationsFileStreamCoordinator();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamCoordinator.run(fileSystemService, libraryName, libraryAnnotationsFilePath);
    }
}