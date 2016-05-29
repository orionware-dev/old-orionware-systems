package core.configuration.services.classpath;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationService;
import core.configuration.LibraryConfiguration;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}