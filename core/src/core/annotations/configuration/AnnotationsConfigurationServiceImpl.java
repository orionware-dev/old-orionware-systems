package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.annotations.registry.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.registry.OrionRegistry;
import core.registry.RegisteredAnnotations;

public class AnnotationsConfigurationServiceImpl implements AnnotationsConfigurationService
{
    private FileSystemService fileSystemService;
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private GetAnnotationsFileStreamTask getAnnotationsFileStreamTask;
    private AnnotationsRegistrationService annotationsRegistrationService;
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask;
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask;
    
    
    public AnnotationsConfigurationServiceImpl()
    {
        this.fileSystemService = new FileSystemServiceImpl();
        this.annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
        this.getClasspathRootPathTask = new GetClasspathRootPathTask();
        this.getAnnotationsFileStreamTask = new GetAnnotationsFileStreamTask();
        this.registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        this.loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        OrionRegistry.registerAnnotation(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.stream()
            .filter((libraryConfiguration) -> libraryConfiguration.getAnnotationsFilePath() != null)
            .filter((libraryConfiguration) -> annotationsRegistrationService.haveAnnotationsNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()))
            .forEach((libraryConfiguration) -> registerLibraryAnnotationsTask.run(this, loadLibraryAnnotationsDefinitionsTask, annotationsRegistrationService, libraryConfiguration));
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamTask.run(this, getClasspathRootPathTask, libraryAnnotationsFilePath, libraryName);
    }
    
    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return fileSystemService.getFileStream(filePath);
    }
    
    
    @Override
    public void closeResource(Closeable stream)
    {
        fileSystemService.closeResource(stream);
    }
}