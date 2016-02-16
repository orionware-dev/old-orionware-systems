package core.configuration.classpath;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.tasks.GetClasspathRootPathTask;
import core.configuration.classpath.tasks.GetClasspathRootTask;
import core.configuration.classpath.tasks.GetConfigurationPathTask;
import core.configuration.classpath.tasks.IsCoreLibraryTask;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.PropertiesRegistrationServiceImpl;
import core.configuration.registry.tasks.RegisterLibraryPropertiesTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class ConfigurationServiceImpl extends ConfigurationObject implements ConfigurationService
{
    private IsCoreLibraryTask isCoreLibraryTask = new IsCoreLibraryTask();
    private GetClasspathRootPathTask getClasspathRootPathTask = new GetClasspathRootPathTask();
    private GetClasspathRootTask getClasspathRootTask = new GetClasspathRootTask();
    private FileSystemService fileSystemService = new FileSystemServiceImpl();
    private GetConfigurationPathTask getConfigurationPathTask = new GetConfigurationPathTask();
    private PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
    private RegisterLibraryPropertiesTask registerLibraryPropertiesTask = new RegisterLibraryPropertiesTask();
    private LoadLibraryPropertiesTask loadLibraryPropertiesTask = new LoadLibraryPropertiesTask();
    
    
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return isCoreLibraryTask.run(classBeingRun);
    }
    
    
    @Override
    public String getClasspathRootPath(String libraryClasspathRootPath)
    {
        return getClasspathRootPathTask.run(libraryClasspathRootPath);
    }
    
    
    @Override
    public File getClasspathRoot(String libraryClasspathRootPath)
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
}