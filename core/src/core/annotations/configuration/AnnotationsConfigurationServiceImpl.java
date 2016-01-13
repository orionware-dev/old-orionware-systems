package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadAnnotationsTask;
import core.configuration.RegisteredAnnotation;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.general.Triple;
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
        return (InputStream)new GetAnnotationsFileStreamTask().run(this, new GetClasspathRootPathTask(), libraryAnnotationsFilePath, libraryName);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibraryAnnotations(Triple<String, String, String> libraryNameAndConfigurationFilePathAndAnnotationsFilePath)
    {
        new LoadAnnotationsTask().run(this, libraryNameAndConfigurationFilePathAndAnnotationsFilePath);
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