package core.configuration;

import core.configuration.tasks.GetClasspathRootPathTask;
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
        return (String)new GetClasspathRootPathTask().run(libraryClasspathRootPath);
    }
    
    
    @Override
    public String getCoreConfigurationPath()
    {
        return (String)new GetConfigurationPathTask().run(null, new GetClasspathRootPathTask());
    }


    @Override
    public void loadProperties(String libraryName, String libraryConfigurationFilePath)
    {
        new LoadPropertiesTask().run(this, libraryName, libraryConfigurationFilePath, new GetClasspathRootPathTask());
    }
    
    
    @Override
    public FileSystemService getFileSystemService()
    {
        return fileSystemService;
    }
}