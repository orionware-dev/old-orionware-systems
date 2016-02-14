package core.configuration.classpath;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionConfigurationService;

public interface ConfigurationService extends OrionConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public String getClasspathRootPath(String libraryClasspathRootPath);
    
    
    public File getClasspathRoot(String libraryClasspathRootPath);
    
    
    public String getCoreConfigurationPath();
    
    
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}