package core.annotations.loader;

import java.io.InputStream;
import core.annotations.loader.filestream.GetAnnotationsFileStreamHelper;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private GetAnnotationsFileStreamHelper getAnnotationsFileStreamHelper = new GetAnnotationsFileStreamHelper();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamHelper.run(fileSystemService, libraryName, libraryAnnotationsFilePath);
    }
}