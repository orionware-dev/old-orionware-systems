package core.configuration;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.tasks.RegisterLibraryPropertiesTask;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibraryPropertiesTask;
import core.filesystem.FileSystemService;

public class ConfigurationServiceImpl implements ConfigurationService
{
    private GetClasspathRootPathTask getClasspathRootPathTask;
    private GetClasspathRootTask getClasspathRootTask;
    private GetConfigurationPathTask getConfigurationPathTask;
    private FileSystemService fileSystemService;
    private PropertiesRegistrationService propertiesRegistrationService;
    private RegisterLibraryPropertiesTask registerLibraryPropertiesTask;
    private LoadLibraryPropertiesTask loadLibraryPropertiesTask;
    
    
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
        librariesConfiguration.stream()
            .filter((libraryConfiguration) -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter((libraryConfiguration) -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()))
            .forEach((libraryConfiguration) -> registerLibraryPropertiesTask.run(this, getClasspathRootPathTask, loadLibraryPropertiesTask, propertiesRegistrationService, libraryConfiguration));
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


    public void setFileSystemService(FileSystemService fileSystemService)
    {
        this.fileSystemService = fileSystemService;
    }


    public void setLibraryPropertiesRegistrationService(PropertiesRegistrationService propertiesRegistrationService)
    {
        this.propertiesRegistrationService = propertiesRegistrationService;
    }


    public void setLoadLibraryPropertiesTask(LoadLibraryPropertiesTask loadLibraryPropertiesTask)
    {
        this.loadLibraryPropertiesTask = loadLibraryPropertiesTask;
    }


    public void setPropertiesRegistrationService(PropertiesRegistrationService propertiesRegistrationService)
    {
        this.propertiesRegistrationService = propertiesRegistrationService;
    }


    public void setRegisterLibraryPropertiesTask(RegisterLibraryPropertiesTask registerLibraryPropertiesTask)
    {
        this.registerLibraryPropertiesTask = registerLibraryPropertiesTask;
    }
}