package core.annotations.configuration;

import java.io.InputStream;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadAnnotationsTask;
import core.configuration.RegisteredAnnotation;
import core.configuration.tasks.GetClasspathRootTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.registry.RegisteredAnnotations;

public class AnnotationsConfigurationServiceImpl implements AnnotationsConfigurationService
{
    private FileSystemService fileSystemService;
    
    
    public AnnotationsConfigurationServiceImpl()
    {
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        GetClasspathRootTask getClasspathRootTask = new GetClasspathRootTask(libraryName);
        GetAnnotationsFileStreamTask getAnnotationsFileStreamTask = new GetAnnotationsFileStreamTask(this, getClasspathRootTask, libraryAnnotationsFilePath);
        return (InputStream)getAnnotationsFileStreamTask.execute();
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibraryAnnotations(String libraryName, String libraryAnnotationsFilePath)
    {
        new LoadAnnotationsTask(this, libraryName, libraryAnnotationsFilePath).execute();
    }
    
    
    @Override
    public FileSystemService getFileSystemService()
    {
        return fileSystemService;
    }
}