package core.annotations.services.loader;

import java.io.InputStream;
import core.OrionSimpleObject;
import core.annotations.AnnotationObject;
import core.annotations.services.loader.tasks.GetAnnotationsFilePathTask;
import core.configuration.classpath.tasks.GetClasspathRootPathTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationObject implements AnnotationsLoaderService
{
    private GetClasspathRootPathTask getClasspathRootTask = new GetClasspathRootPathTask();
    private GetAnnotationsFilePathTask getAnnotationsFilePathTask = new GetAnnotationsFilePathTask();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        String coreClasspathRoot = getClasspathRootTask.run(libraryName);
        String annotationsFilePath = getAnnotationsFilePathTask.run(coreClasspathRoot, libraryAnnotationsFilePath);
        return fileSystemService.getFileStream(annotationsFilePath);
    }
}