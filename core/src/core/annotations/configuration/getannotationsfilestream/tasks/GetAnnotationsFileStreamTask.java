package core.annotations.configuration.getannotationsfilestream.tasks;

import java.io.InputStream;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask implements OrionTask
{
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    
    
    public InputStream run(String classpathRoot, String libraryAnnotationsFilePath, String libraryName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return fileSystemService.getFileStream(sb.toString());
    }
}