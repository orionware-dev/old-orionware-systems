package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
import core.configuration.RegisteredAnnotation;
import core.general.Triple;
import core.services.OrionService;

public interface AnnotationsConfigurationService extends OrionService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
    
    
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation);
    
    
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths);
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}