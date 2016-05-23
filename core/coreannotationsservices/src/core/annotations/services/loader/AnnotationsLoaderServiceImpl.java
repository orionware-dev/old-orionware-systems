package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.AnnotationObject;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationObject implements AnnotationsLoaderService
{
    private FileSystemService fileSystemService;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return fileSystemService.getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}