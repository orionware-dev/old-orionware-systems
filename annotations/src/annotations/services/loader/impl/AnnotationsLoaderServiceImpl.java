package annotations.services.loader.impl;

import java.io.InputStream;
import annotations.services.AnnotationServiceObject;
import annotations.services.loader.AnnotationsLoaderService;
import annotations.services.loader.impl.tasks.GetAnnotationsDefinitionFileStreamTask;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return new GetAnnotationsDefinitionFileStreamTask().run(libraryAnnotationsDefinitionFilePath);
    }
}