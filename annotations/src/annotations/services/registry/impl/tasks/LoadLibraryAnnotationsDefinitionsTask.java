package annotations.services.registry.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;
import annotations.services.loader.AnnotationsLoaderService;
import annotations.services.loader.impl.AnnotationsLoaderServiceImpl;
import configuration.LibraryConfiguration;
import configuration.OrionProperties;
import filesystem.services.streams.FileSystemStreamsService;
import filesystem.services.streams.impl.FileSystemStreamsServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        OrionProperties annotationsDeclarations = new OrionProperties();
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        FileSystemStreamsService fileSystemStreamsService = new FileSystemStreamsServiceImpl();
        fileSystemStreamsService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}