package core.annotations.loader;

import java.io.InputStream;
import core.annotations.loader.tasks.GetAnnotationsFilePathTask;
import core.configuration.classpath.tasks.GetCoreClasspathRootPathTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private GetCoreClasspathRootPathTask getCoreClasspathRootTask = new GetCoreClasspathRootPathTask();
    private GetAnnotationsFilePathTask getAnnotationsFilePathTask = new GetAnnotationsFilePathTask();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        String coreClasspathRoot = getCoreClasspathRootTask.run(libraryName);
        String annotationsFilePath = getAnnotationsFilePathTask.run(coreClasspathRoot, libraryAnnotationsFilePath);
        return fileSystemService.getFileStream(annotationsFilePath);
    }
}