package core.annotations.services.loader.impl;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.impl.tasks.GetAnnotationsDefinitionFileStreamTask;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return new GetAnnotationsDefinitionFileStreamTask().run(libraryAnnotationsDefinitionFilePath);
    }
}