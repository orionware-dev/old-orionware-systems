package core.annotations.services.loader.impl;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.impl.tasks.GetAnnotationsDefinitionFileStreamTask;

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