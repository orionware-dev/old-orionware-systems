package core.annotations.registry.tasks;

import java.io.InputStream;
import core.annotations.loader.AnnotationsLoaderService;
import core.configuration.LibraryConfiguration;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.general.OrionProperties;
import core.services.OrionTask;

public class LoadLibraryAnnotationsDefinitionsTask implements OrionTask
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