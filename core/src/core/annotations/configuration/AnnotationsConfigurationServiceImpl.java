package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.loadlibrariesannotations.LoadLibrariesAnnotationsHelper;
import core.annotations.configuration.registerannotation.RegisterAnnotationHelper;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class AnnotationsConfigurationServiceImpl implements AnnotationsConfigurationService
{
    private RegisterAnnotationHelper registerAnnotationHelper = new RegisterAnnotationHelper();
    private LoadLibrariesAnnotationsHelper loadLibrariesAnnotationsHelper = new LoadLibrariesAnnotationsHelper();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    private GetClasspathRootPathTask getClasspathRootPathTask = new GetClasspathRootPathTask();
    private GetAnnotationsFileStreamTask getAnnotationsFileStreamTask = new GetAnnotationsFileStreamTask();
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationHelper.registerAnnotation(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        loadLibrariesAnnotationsHelper.loadLibrariesAnnotations(librariesConfiguration);
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