package core.configuration;

import core.filesystem.FileSystemService;
import core.services.OrionService;

public interface ConfigurationService extends OrionService
{
    public String getCoreClasspathRoot(String libraryClasspathRootPath);
    
    
    public String getCoreConfigurationPath();
    
    
    public void loadProperties(String libraryName, String libraryConfigurationFilePath);
    
    
    public FileSystemService getFileSystemService();
}