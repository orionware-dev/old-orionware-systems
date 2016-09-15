package annotations.registry.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.loading.AnnotationsLoaderService;
import annotations.loading.impl.AnnotationsLoaderServiceImpl;
import configuration.LibraryConfiguration;
import configuration.OrionProperties;
import filesystem.streams.FileSystemStreamsService;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    private static AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    private static FileSystemStreamsService fileSystemStreamsService = new FileSystemStreamsServiceImpl();
    
    
    public static OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        OrionProperties annotationsDeclarations = new OrionProperties();
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemStreamsService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}