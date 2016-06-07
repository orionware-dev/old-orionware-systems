package core.annotations.services.registry.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.impl.AnnotationsLoaderServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.filesystem.facades.streams.FileSystemStreamsFacade;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    private OrionProperties annotationsDeclarations;
    private FileSystemStreamsFacade fileSystemStreamsFacade;
    private AnnotationsLoaderService annotationsLoaderService;
    
    
    public LoadLibraryAnnotationsDefinitionsTask()
    {
        this.annotationsDeclarations = new OrionProperties();
        this.fileSystemStreamsFacade = new FileSystemStreamsFacadeImpl();
        this.annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    }
    
    
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemStreamsFacade.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}