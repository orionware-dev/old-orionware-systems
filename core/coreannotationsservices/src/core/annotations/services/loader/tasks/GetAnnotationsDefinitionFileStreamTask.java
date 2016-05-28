package core.annotations.services.loader.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.filesystem.streams.FileSystemServiceImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemServiceImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}