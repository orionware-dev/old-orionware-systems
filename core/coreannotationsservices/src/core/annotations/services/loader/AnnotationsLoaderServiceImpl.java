package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.AnnotationObject;
import core.annotations.services.loader.tasks.GetAnnotationsFilePathTask;
import core.configuration.classpath.tasks.GetClasspathRootPathTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationObject implements AnnotationsLoaderService
{
    private GetClasspathRootPathTask getClasspathRootTask;
    private GetAnnotationsFilePathTask getAnnotationsFilePathTask;
    private FileSystemService fileSystemService;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        getClasspathRootTask = new GetClasspathRootPathTask();
        getAnnotationsFilePathTask = new GetAnnotationsFilePathTask();
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        String coreClasspathRoot = getClasspathRootTask.run(libraryName);
        String annotationsFilePath = getAnnotationsFilePathTask.run(coreClasspathRoot, libraryAnnotationsFilePath);
        return fileSystemService.getFileStream(annotationsFilePath);
    }
}