package core.configuration;

import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadPropertiesTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class ConfigurationServiceImpl implements ConfigurationService
{
    private FileSystemServiceImpl fileSystemService;
    
    
    public ConfigurationServiceImpl()
    {
        fileSystemService = new FileSystemServiceImpl();
    }
    
    
    @Override
    public String getCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return (String)new GetClasspathRootTask(libraryClasspathRootPath).execute();
    }
    
    
    @Override
    public String getCoreConfigurationPath()
    {
        return (String)new GetConfigurationPathTask(null).execute();
    }


    @Override
    public void loadProperties(String libraryName, String libraryConfigurationFilePath)
    {
        new LoadPropertiesTask(this, libraryName, libraryConfigurationFilePath).execute();
    }
    
    
    @Override
    public FileSystemService getFileSystemService()
    {
        return fileSystemService;
    }
}