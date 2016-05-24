package core.annotations.services.loader.tasks;

import java.io.InputStream;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.filesystem.streams.FileSystemService;
import core.reflection.loader.ReflectionService;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(FileSystemService fileSystemService, String libraryAnnotationsDefinitionFilePath)
    {
        return fileSystemService.getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}