package core.configuration.classpath;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.tasks.IsCoreLibraryTask;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.PropertiesRegistrationServiceImpl;
import core.configuration.registry.tasks.RegisterLibraryPropertiesTask;
import core.filesystem.streams.FileSystemService;
import core.filesystem.streams.FileSystemServiceImpl;

public class ConfigurationServiceImpl extends ConfigurationObject implements ConfigurationService
{
    private IsCoreLibraryTask isCoreLibraryTask;
    private FileSystemService fileSystemService;
    private PropertiesRegistrationService propertiesRegistrationService;
    private RegisterLibraryPropertiesTask registerLibraryPropertiesTask;
    private LoadLibraryPropertiesTask loadLibraryPropertiesTask;
    
    
    public ConfigurationServiceImpl()
    {
        isCoreLibraryTask = new IsCoreLibraryTask();
        fileSystemService = new FileSystemServiceImpl();
        propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        registerLibraryPropertiesTask = new RegisterLibraryPropertiesTask();
        loadLibraryPropertiesTask = new LoadLibraryPropertiesTask();
    }
    
    
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return isCoreLibraryTask.run(classBeingRun);
    }


    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.stream()
            .filter((libraryConfiguration) -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter((libraryConfiguration) -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()))
            .forEach((libraryConfiguration) -> registerLibraryPropertiesTask.run(this, loadLibraryPropertiesTask, propertiesRegistrationService, libraryConfiguration));
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