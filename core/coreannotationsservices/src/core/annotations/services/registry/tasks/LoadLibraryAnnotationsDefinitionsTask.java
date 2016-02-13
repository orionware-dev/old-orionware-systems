package core.annotations.services.registry.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask implements AnnotationTask
{
    private OrionProperties annotationsDeclarations = new OrionProperties();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    public OrionProperties run(AnnotationsLoaderService annotationsLoaderService, LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsFileStream(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}