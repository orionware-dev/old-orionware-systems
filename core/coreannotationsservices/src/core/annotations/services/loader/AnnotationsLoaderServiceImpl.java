package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.tasks.GetAnnotationsDefinitionFileStreamTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    private FileSystemService fileSystemService;
    private GetAnnotationsDefinitionFileStreamTask getAnnotationsDefinitionFileStreamTask;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        this.fileSystemService = new FileSystemServiceImpl();
        this.getAnnotationsDefinitionFileStreamTask = new GetAnnotationsDefinitionFileStreamTask();
    }
    
    
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return getAnnotationsDefinitionFileStreamTask.run(fileSystemService, libraryAnnotationsDefinitionFilePath);
    }
}