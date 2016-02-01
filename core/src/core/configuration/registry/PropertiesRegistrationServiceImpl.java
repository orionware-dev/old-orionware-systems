package core.configuration.registry;

import core.configuration.registry.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.tasks.SetPropertiesAsRegisteredForLibraryTask;

public class PropertiesRegistrationServiceImpl implements PropertiesRegistrationService
{
    private HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask = new HavePropertiesBeenRegisteredForLibraryTask();
    private SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask = new SetPropertiesAsRegisteredForLibraryTask();
    
    
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName)
    {
        return havePropertiesBeenRegisteredForLibraryTask.run(libraryName);
    }

    
    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setPropertiesAsRegisteredForLibrary(String libraryName)
    {
        setPropertiesAsRegisteredForLibraryTask.run(libraryName);
    }
}