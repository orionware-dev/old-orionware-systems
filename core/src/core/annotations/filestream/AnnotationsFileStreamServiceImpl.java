package core.annotations.filestream;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.annotations.filestream.tasks.GetAnnotationsFileStreamTask;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.registry.RegisteredAnnotations;

public class AnnotationsFileStreamServiceImpl implements AnnotationsFileStreamService
{
    private FileSystemService fileSystemService;
    
    
    public AnnotationsFileStreamServiceImpl()
    {
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return new GetAnnotationsFileStreamTask().run(this, new GetClasspathRootPathTask(), libraryAnnotationsFilePath, libraryName);
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