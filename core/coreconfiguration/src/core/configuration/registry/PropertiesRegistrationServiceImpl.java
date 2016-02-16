package core.configuration.registry;

import core.OrionSimpleObject;
import core.configuration.registry.tasks.DeletePropertyTask;
import core.configuration.registry.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.tasks.RegisterPropertyTask;
import core.configuration.registry.tasks.SetPropertiesAsRegisteredForLibraryTask;
import core.configuration.registry.tasks.UpdatePropertyTask;

public class PropertiesRegistrationServiceImpl extends OrionSimpleObject implements PropertiesRegistrationService
{
    private HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask = new HavePropertiesBeenRegisteredForLibraryTask();
    private SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask = new SetPropertiesAsRegisteredForLibraryTask();
    private RegisterPropertyTask registerPropertyTask = new RegisterPropertyTask();
    private UpdatePropertyTask updatePropertyTask = new UpdatePropertyTask();
    private DeletePropertyTask deletePropertyTask = new DeletePropertyTask();
    
    
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
    
    
    @Override
    public void registerProp(String key, String value)
    {
        registerPropertyTask.run(key, value);
    }
    
    
    @Override
    public void updateProp(String key, String value)
    {
        updatePropertyTask.run(key, value);
    }
    
    
    @Override
    public void deleteProp(String key)
    {
        deletePropertyTask.run(key);
    }
}