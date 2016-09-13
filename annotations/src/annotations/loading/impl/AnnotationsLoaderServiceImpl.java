package annotations.loading.impl;

import java.io.InputStream;
import annotations.AnnotationServiceObject;
import annotations.loading.AnnotationsLoaderService;
import annotations.loading.impl.tasks.GetAnnotationsDefinitionFileStreamTask;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        return new GetAnnotationsDefinitionFileStreamTask().run(libraryAnnotationsDefinitionFilePath);
    }
}