package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.PropertiesRegistrationServiceImpl;
import core.configuration.registry.tasks.RegisterLibraryPropertiesTask;
import core.configuration.tasks.GetCoreClasspathRootPathTask;
import core.configuration.tasks.GetCoreClasspathRootTask;
import core.configuration.tasks.GetCoreConfigurationPathTask;
import core.configuration.tasks.LoadLibraryPropertiesTask;
import core.filesystem.FileSystemService;
import core.filesystem.FileSystemServiceImpl;

public class ConfigurationServiceImpl implements ConfigurationService
{
    private GetCoreClasspathRootPathTask getCoreClasspathRootPathTask = new GetCoreClasspathRootPathTask();
    private GetCoreClasspathRootTask getCoreClasspathRootTask = new GetCoreClasspathRootTask();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    private GetCoreConfigurationPathTask getCoreConfigurationPathTask = new GetCoreConfigurationPathTask();
    private PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
    private RegisterLibraryPropertiesTask registerLibraryPropertiesTask = new RegisterLibraryPropertiesTask();
    private LoadLibraryPropertiesTask loadLibraryPropertiesTask = new LoadLibraryPropertiesTask();
    
    
    @Override
    public String getCoreClasspathRootPath(String libraryClasspathRootPath)
    {
        return getCoreClasspathRootPathTask.run(libraryClasspathRootPath);
    }
    
    
    @Override
    public File getCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return getCoreClasspathRootTask.run(libraryClasspathRootPath, getCoreClasspathRootPathTask);
    }
    
    
    @Override
    public String getCoreConfigurationPath()
    {
        return getCoreConfigurationPathTask.run(null, getCoreClasspathRootPathTask);
    }


    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.stream()
            .filter((libraryConfiguration) -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter((libraryConfiguration) -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()))
            .forEach((libraryConfiguration) -> registerLibraryPropertiesTask.run(this, getCoreClasspathRootPathTask, loadLibraryPropertiesTask, propertiesRegistrationService, libraryConfiguration));
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
}