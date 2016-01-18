package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibrariesPropertiesTask;
import core.filesystem.FileSystemServiceImpl;

public class ConfigurationServiceImpl implements ConfigurationService
{
    @Override
    public String getCoreClasspathRootPath(String libraryClasspathRootPath)
    {
        return new GetClasspathRootPathTask().run(libraryClasspathRootPath);
    }
    
    
    @Override
    public File getCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return new GetClasspathRootTask().run(libraryClasspathRootPath, new GetClasspathRootPathTask());
    }
    
    
    @Override
    public String getCoreConfigurationPath()
    {
        return new GetConfigurationPathTask().run(null, new GetClasspathRootPathTask());
    }


    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        new LoadLibrariesPropertiesTask().run(this, librariesConfiguration, new GetClasspathRootPathTask());
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