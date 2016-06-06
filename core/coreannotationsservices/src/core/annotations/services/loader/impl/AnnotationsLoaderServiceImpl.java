package core.annotations.services.loader.impl;

import java.io.InputStream;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.impl.tasks.GetAnnotationsDefinitionFileStreamTask;
import core.filesystem.facades.streams.FileSystemStreamsFacade;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationServiceObject implements AnnotationsLoaderService
{
    @Override
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath)
    {
        FileSystemStreamsFacade fileSystemStreamsFacade = new FileSystemStreamsFacadeImpl();
        return new GetAnnotationsDefinitionFileStreamTask().run(libraryAnnotationsDefinitionFilePath, fileSystemStreamsFacade::getFileStream);
    }
}