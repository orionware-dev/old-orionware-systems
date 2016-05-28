package core.annotations.services.loader.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemStreamsServiceImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}