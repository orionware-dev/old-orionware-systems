package core.configuration.registry;

import core.configuration.registry.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.tasks.SetPropertiesAsRegisteredForLibraryTask;

public class PropertiesRegistrationServiceImpl implements PropertiesRegistrationService
{
    private HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask;
    private SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask;
    
    
    public PropertiesRegistrationServiceImpl()
    {
        new PropertiesRegistrationServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
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


    public void setHavePropertiesBeenRegisteredForLibraryTask(HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask)
    {
        this.havePropertiesBeenRegisteredForLibraryTask = havePropertiesBeenRegisteredForLibraryTask;
    }


    public void setSetPropertiesAsRegisteredForLibraryTask(SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask)
    {
        this.setPropertiesAsRegisteredForLibraryTask = setPropertiesAsRegisteredForLibraryTask;
    }
}