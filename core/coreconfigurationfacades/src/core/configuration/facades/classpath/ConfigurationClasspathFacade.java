package core.configuration.facades.classpath;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationFacade;
import core.configuration.LibraryConfiguration;
import core.services.OrionFacade;

public interface ConfigurationClasspathFacade extends ConfigurationFacade
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}