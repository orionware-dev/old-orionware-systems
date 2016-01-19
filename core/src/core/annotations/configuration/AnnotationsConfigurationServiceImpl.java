package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.registry.RegisteredAnnotations;

public class AnnotationsConfigurationServiceImpl implements AnnotationsConfigurationService
{
    private FileSystemService fileSystemService;
    private LoadLibrariesAnnotationsTask loadLibrariesAnnotationsTask;
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private GetAnnotationsFileStreamTask getAnnotationsFileStreamTask;
    
    
    public AnnotationsConfigurationServiceImpl()
    {
        new AnnotationsConfigurationServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        loadLibrariesAnnotationsTask.run(this, librariesConfiguration);
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


    public void setFileSystemService(FileSystemService fileSystemService)
    {
        this.fileSystemService = fileSystemService;
    }


    public void setLoadLibrariesAnnotationsTask(LoadLibrariesAnnotationsTask loadLibrariesAnnotationsTask)
    {
        this.loadLibrariesAnnotationsTask = loadLibrariesAnnotationsTask;
    }


    public void setGetClasspathRootPathTask(GetClasspathRootPathTask getClasspathRootPathTask)
    {
        this.getClasspathRootPathTask = getClasspathRootPathTask;
    }


    public void setGetAnnotationsFileStreamTask(GetAnnotationsFileStreamTask getAnnotationsFileStreamTask)
    {
        this.getAnnotationsFileStreamTask = getAnnotationsFileStreamTask;
    }
}