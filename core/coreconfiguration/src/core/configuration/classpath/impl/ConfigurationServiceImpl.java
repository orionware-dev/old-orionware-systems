package core.configuration.classpath.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.impl.tasks.IsCoreLibraryTask;
import core.configuration.classpath.impl.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.impl.PropertiesRegistrationServiceImpl;
import core.configuration.registry.impl.tasks.RegisterLibraryPropertiesTask;
import core.filesystem.streams.FileSystemStreamsService;
import core.filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class ConfigurationServiceImpl extends ConfigurationObject implements ConfigurationService
{
    private IsCoreLibraryTask isCoreLibraryTask;
    private FileSystemStreamsService fileSystemStreamsService;
    private PropertiesRegistrationService propertiesRegistrationService;
    private RegisterLibraryPropertiesTask registerLibraryPropertiesTask;
    private LoadLibraryPropertiesTask loadLibraryPropertiesTask;
    
    
    public ConfigurationServiceImpl()
    {
        this.isCoreLibraryTask = new IsCoreLibraryTask();
        this.fileSystemStreamsService = new FileSystemStreamsServiceImpl();
        this.propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        this.registerLibraryPropertiesTask = new RegisterLibraryPropertiesTask();
        this.loadLibraryPropertiesTask = new LoadLibraryPropertiesTask();
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
        return fileSystemStreamsService.getFileStream(filePath);
    }
    
    
    @Override
    public void closeResource(Closeable stream)
    {
        fileSystemStreamsService.closeResource(stream);
    }
}