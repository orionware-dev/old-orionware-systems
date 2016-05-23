package core.annotations.services.registry.tasks;

import java.io.InputStream;
import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationObject implements AnnotationTask
{
    private OrionProperties annotationsDeclarations;
    private FileSystemService fileSystemService;
    
    
    public LoadLibraryAnnotationsDefinitionsTask()
    {
        annotationsDeclarations = new OrionProperties();
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    public OrionProperties run(AnnotationsLoaderService annotationsLoaderService, LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}