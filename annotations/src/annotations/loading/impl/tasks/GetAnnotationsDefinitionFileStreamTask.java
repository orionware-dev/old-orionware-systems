package annotations.loading.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemStreamsServiceImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}