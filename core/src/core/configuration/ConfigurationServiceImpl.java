package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadPropertiesTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class ConfigurationServiceImpl implements ConfigurationService
{
    @Override
    public String getCoreClasspathRootPath(String libraryClasspathRootPath)
    {
        return (String)new GetClasspathRootPathTask().run(libraryClasspathRootPath);
    }
    
    
    @Override
    public File getCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return (File)new GetClasspathRootTask().run(libraryClasspathRootPath, new GetClasspathRootPathTask());
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
    public InputStream getFileStream(String filePath)
    {
        return new FileSystemServiceImpl().getFileStream(filePath);
    }
    
    
    @Override
    public void closeResource(Closeable stream)
    {
        new FileSystemServiceImpl().closeResource(stream);
    }
}