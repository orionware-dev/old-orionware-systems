package core.annotations.services.loader.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public static InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}