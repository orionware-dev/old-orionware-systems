package core.annotations.loader;

import java.io.InputStream;
import core.annotations.loader.filestream.AnnotationsFileStreamCoordinator;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private AnnotationsFileStreamCoordinator annotationsFileStreamCoordinator = new AnnotationsFileStreamCoordinator();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return annotationsFileStreamCoordinator.run(fileSystemService, libraryName, libraryAnnotationsFilePath);
    }
}