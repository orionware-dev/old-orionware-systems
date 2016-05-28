package core.annotations.services.registry.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.impl.AnnotationsLoaderServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.filesystem.streams.FileSystemStreamsService;
import core.filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    private OrionProperties annotationsDeclarations;
    private FileSystemStreamsService fileSystemStreamsService;
    private AnnotationsLoaderService annotationsLoaderService;
    
    
    public LoadLibraryAnnotationsDefinitionsTask()
    {
        this.annotationsDeclarations = new OrionProperties();
        this.fileSystemStreamsService = new FileSystemStreamsServiceImpl();
        this.annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    }
    
    
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemStreamsService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}