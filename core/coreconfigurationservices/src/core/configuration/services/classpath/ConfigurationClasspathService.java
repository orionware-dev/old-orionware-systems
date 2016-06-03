package core.configuration.services.classpath;

import java.io.Closeable;
import java.io.InputStream;
import core.configuration.ConfigurationService;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties();
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}