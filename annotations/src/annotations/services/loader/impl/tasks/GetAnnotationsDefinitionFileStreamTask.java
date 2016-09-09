package annotations.services.loader.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;
import filesystem.services.streams.impl.FileSystemStreamsServiceImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemStreamsServiceImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}