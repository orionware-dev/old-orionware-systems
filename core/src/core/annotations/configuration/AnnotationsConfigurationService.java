package core.annotations.configuration;

import java.io.InputStream;
import core.configuration.RegisteredAnnotation;
import core.filesystem.FileSystemService;
import core.services.OrionService;

public interface AnnotationsConfigurationService extends OrionService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
    
    
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation);
    
    
    public void loadLibraryAnnotations(String libraryName, String libraryAnnotationsFilePath);
    
    
    public FileSystemService getFileSystemService();
}