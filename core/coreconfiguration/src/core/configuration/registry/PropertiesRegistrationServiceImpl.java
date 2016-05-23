package core.configuration.registry;

import core.configuration.ConfigurationObject;
import core.configuration.registry.tasks.DeletePropertyTask;
import core.configuration.registry.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.tasks.RegisterPropertyTask;
import core.configuration.registry.tasks.SetPropertiesAsRegisteredForLibraryTask;
import core.configuration.registry.tasks.UpdatePropertyTask;

public class PropertiesRegistrationServiceImpl extends ConfigurationObject implements PropertiesRegistrationService
{
    private HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask;
    private SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask;
    private RegisterPropertyTask registerPropertyTask;
    private UpdatePropertyTask updatePropertyTask;
    private DeletePropertyTask deletePropertyTask;
    
    
    public PropertiesRegistrationServiceImpl()
    {
        havePropertiesBeenRegisteredForLibraryTask = new HavePropertiesBeenRegisteredForLibraryTask();
        setPropertiesAsRegisteredForLibraryTask = new SetPropertiesAsRegisteredForLibraryTask();
        registerPropertyTask = new RegisterPropertyTask();
        updatePropertyTask = new UpdatePropertyTask();
        deletePropertyTask = new DeletePropertyTask();
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