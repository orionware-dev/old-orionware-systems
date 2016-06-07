package core.configuration.facades.classpath;

import java.io.Closeable;
import java.io.InputStream;
import core.configuration.ConfigurationFacade;

public interface ConfigurationClasspathFacade extends ConfigurationFacade
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties();
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}