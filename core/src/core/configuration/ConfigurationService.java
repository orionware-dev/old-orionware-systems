package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.services.OrionService;

public interface ConfigurationService extends OrionService
{
    public String getCoreClasspathRootPath(String libraryClasspathRootPath);
    
    
    public File getCoreClasspathRoot(String libraryClasspathRootPath);
    
    
    public String getCoreConfigurationPath();
    
    
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public InputStream getFileStream(String filePath);
    
    
    public void closeResource(Closeable stream);
}