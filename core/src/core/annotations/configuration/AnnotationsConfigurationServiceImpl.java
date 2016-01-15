package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.configuration.RegisteredAnnotation;
import core.configuration.tasks.GetClasspathRootPathTask;
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
        return new GetAnnotationsFileStreamTask().run(this, new GetClasspathRootPathTask(), libraryAnnotationsFilePath, libraryName);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        new LoadLibrariesAnnotationsTask().run(this, librariesConfiguration);
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