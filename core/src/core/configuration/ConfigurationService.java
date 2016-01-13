package core.configuration;

import java.io.File;
import core.filesystem.FileSystemService;
import core.services.OrionService;

public interface ConfigurationService extends OrionService
{
    public String getCoreClasspathRootPath(String libraryClasspathRootPath);
    
    
    public File getCoreClasspathRoot(String libraryClasspathRootPath);
    
    
    public String getCoreConfigurationPath();
    
    
    public void loadProperties(String libraryName, String libraryConfigurationFilePath);
    
    
    public FileSystemService getFileSystemService();
}