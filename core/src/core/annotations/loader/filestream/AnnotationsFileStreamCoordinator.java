package core.annotations.loader.filestream;

import java.io.InputStream;
import core.annotations.loader.filestream.tasks.GetAnnotationsFilePathTask;
import core.configuration.tasks.GetCoreClasspathRootPathTask;
import core.filesystem.FileSystemService;
import core.services.OrionServiceCoordinator;

public class AnnotationsFileStreamCoordinator implements OrionServiceCoordinator
{
    private GetCoreClasspathRootPathTask getCoreClasspathRootTask = new GetCoreClasspathRootPathTask();
    private GetAnnotationsFilePathTask getAnnotationsFilePathTask = new GetAnnotationsFilePathTask();
    
    
    public InputStream run(FileSystemService fileSystemService, String libraryName, String libraryAnnotationsFilePath)
    {
        String coreClasspathRoot = getCoreClasspathRootTask.run(libraryName);
        String annotationsFilePath = getAnnotationsFilePathTask.run(coreClasspathRoot, libraryAnnotationsFilePath);
        return fileSystemService.getFileStream(annotationsFilePath);
    }
}