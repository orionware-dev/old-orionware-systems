package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.tasks.GetAnnotationsDefinitionFileStreamTask;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    private GetAnnotationsDefinitionFileStreamTask getAnnotationsDefinitionFileStreamTask;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        this.getAnnotationsDefinitionFileStreamTask = new GetAnnotationsDefinitionFileStreamTask();
    }
    
    
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return getAnnotationsDefinitionFileStreamTask.run(libraryAnnotationsDefinitionFilePath);
    }
}