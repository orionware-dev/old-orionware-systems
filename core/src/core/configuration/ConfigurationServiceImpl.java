package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibrariesPropertiesTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class ConfigurationServiceImpl implements ConfigurationService
{
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private GetClasspathRootTask getClasspathRootTask;
    private GetConfigurationPathTask getConfigurationPathTask;
    private LoadLibrariesPropertiesTask loadLibrariesPropertiesTask;
    private FileSystemService fileSystemService;
    
    
    public ConfigurationServiceImpl()
    {
        new ConfigurationServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public String getCoreClasspathRootPath(String libraryClasspathRootPath)
    {
        return getClasspathRootPathTask.run(libraryClasspathRootPath);
    }
    
    
    @Override
    public File getCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return getClasspathRootTask.run(libraryClasspathRootPath, getClasspathRootPathTask);
    }
    
    
    @Override
    public String getCoreConfigurationPath()
    {
        return getConfigurationPathTask.run(null, getClasspathRootPathTask);
    }


    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        loadLibrariesPropertiesTask.run(this, librariesConfiguration, getClasspathRootPathTask);
    }
    
    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return fileSystemService.getFileStream(filePath);
    }
    
    
    @Override
    public void closeResource(Closeable stream)
    {
        fileSystemService.closeResource(stream);
    }


    public void setGetClasspathRootPathTask(GetClasspathRootPathTask getClasspathRootPathTask)
    {
        this.getClasspathRootPathTask = getClasspathRootPathTask;
    }


    public void setGetClasspathRootTask(GetClasspathRootTask getClasspathRootTask)
    {
        this.getClasspathRootTask = getClasspathRootTask;
    }


    public void setGetConfigurationPathTask(GetConfigurationPathTask getConfigurationPathTask)
    {
        this.getConfigurationPathTask = getConfigurationPathTask;
    }


    public void setLoadLibrariesPropertiesTask(LoadLibrariesPropertiesTask loadLibrariesPropertiesTask)
    {
        this.loadLibrariesPropertiesTask = loadLibrariesPropertiesTask;
    }


    public void setFileSystemService(FileSystemService fileSystemService)
    {
        this.fileSystemService = fileSystemService;
    }
}