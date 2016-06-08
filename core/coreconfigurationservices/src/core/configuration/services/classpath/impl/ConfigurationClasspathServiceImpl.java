package core.configuration.services.classpath.impl;

import core.configuration.LibrariesConfiguration;
import core.configuration.services.ConfigurationServiceObject;
import core.configuration.services.classpath.ConfigurationClasspathService;
import core.configuration.services.classpath.impl.tasks.IsCoreLibraryTask;
import core.configuration.services.classpath.impl.tasks.LoadLibraryPropertiesTask;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.PropertiesRegistrationServiceImpl;

public class ConfigurationClasspathServiceImpl extends ConfigurationServiceObject implements ConfigurationClasspathService
{
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return IsCoreLibraryTask.run(classBeingRun);
    }
    
    
    @Override
    public boolean isCoreLibrary(Object objectBeingRun)
    {
        return IsCoreLibraryTask.run(objectBeingRun);
    }


    @Override
    public void loadLibrariesProperties()
    {
        PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        LibrariesConfiguration.getLibrariesConfigurationSet()
            .stream()
            .filter(libraryConfiguration -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter(libraryConfiguration -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryClassPath()))
            .forEach(libraryConfiguration -> 
                {
                    LoadLibraryPropertiesTask.run(libraryConfiguration);
                    new PropertiesRegistrationServiceImpl().setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
                });
    }
}