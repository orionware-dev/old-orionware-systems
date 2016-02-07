package core.annotations.registry.loadlibraryannotationsdefinitions.tasks;

import java.io.InputStream;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.general.OrionProperties;
import core.services.OrionTask;

public class LoadLibraryAnnotationsDefinitionsTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
    private OrionProperties annotationsDeclarations = new OrionProperties();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        InputStream libraryAnnotationsFileStream = annotationsConfigurationService.getAnnotationsFileStream(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        fileSystemService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}