package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.AnnotationObject;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class AnnotationsLoaderServiceImpl extends AnnotationObject implements AnnotationsLoaderService
{
    //private GetClasspathRootPathTask getClasspathRootTask;
    //private GetAnnotationsDefinitionFilePathTask getAnnotationsDefinitionFilePathTask;
    private FileSystemService fileSystemService;
    
    
    public AnnotationsLoaderServiceImpl()
    {
        //getClasspathRootTask = new GetClasspathRootPathTask();
        //getAnnotationsDefinitionFilePathTask = new GetAnnotationsDefinitionFilePathTask();
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryClassPath, String libraryAnnotationsDefinitionFilePath)
    {
        //String coreClasspathRoot = getClasspathRootTask.run(libraryClassPath);
        //String annotationsFilePath = getAnnotationsDefinitionFilePathTask.run(coreClasspathRoot, libraryAnnotationsDefinitionFilePath);
        return fileSystemService.getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}