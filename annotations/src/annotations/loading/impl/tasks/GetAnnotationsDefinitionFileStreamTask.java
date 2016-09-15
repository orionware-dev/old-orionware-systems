package annotations.loading.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import filesystem.streams.FileSystemStreamsService;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    private static FileSystemStreamsService fileSystemStreamsService = new FileSystemStreamsServiceImpl();
    
    
    public static InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return fileSystemStreamsService.getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}