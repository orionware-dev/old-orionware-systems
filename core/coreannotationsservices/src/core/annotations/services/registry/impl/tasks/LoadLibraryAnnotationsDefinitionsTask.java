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
    public OrionProperties run(LibraryConfiguration libraryConfiguration)
    {
        AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
        InputStream libraryAnnotationsFileStream = annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryConfiguration.getAnnotationsDefinitionFilePath());
        OrionProperties annotationsDeclarations = new OrionProperties();
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        FileSystemStreamsFacade fileSystemStreamsFacade = new FileSystemStreamsFacadeImpl();
        fileSystemStreamsFacade.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}