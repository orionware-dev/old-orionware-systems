package core.annotations.configuration;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface AnnotationsConfigurationService extends OrionService
{
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation);
    
    
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration);
}