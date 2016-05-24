package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    private FileSystemService fileSystemService;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return fileSystemService.getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}