package annotations.registry.impl.tasks;

import java.io.InputStream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.loading.AnnotationsLoaderService;
import annotations.loading.impl.AnnotationsLoaderServiceImpl;
import configuration.LibraryConfiguration;
import configuration.OrionProperties;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        OrionProperties annotationsDeclarations = new OrionProperties();
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        new FileSystemStreamsServiceImpl().closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}