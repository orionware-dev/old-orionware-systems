package core.configuration.registry.impl;

import core.configuration.ConfigurationObject;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.registry.impl.tasks.DeletePropertyTask;
import core.configuration.registry.impl.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.impl.tasks.RegisterPropertyTask;
import core.configuration.registry.impl.tasks.SetPropertiesAsRegisteredForLibraryTask;
import core.configuration.registry.impl.tasks.UpdatePropertyTask;

public class PropertiesRegistrationServiceImpl extends ConfigurationObject implements PropertiesRegistrationService
{
    private HavePropertiesBeenRegisteredForLibraryTask havePropertiesBeenRegisteredForLibraryTask;
    private SetPropertiesAsRegisteredForLibraryTask setPropertiesAsRegisteredForLibraryTask;
    private RegisterPropertyTask registerPropertyTask;
    private UpdatePropertyTask updatePropertyTask;
    private DeletePropertyTask deletePropertyTask;
    
    
    public PropertiesRegistrationServiceImpl()
    {
        this.havePropertiesBeenRegisteredForLibraryTask = new HavePropertiesBeenRegisteredForLibraryTask();
        this.setPropertiesAsRegisteredForLibraryTask = new SetPropertiesAsRegisteredForLibraryTask();
        this.registerPropertyTask = new RegisterPropertyTask();
        this.updatePropertyTask = new UpdatePropertyTask();
        this.deletePropertyTask = new DeletePropertyTask();
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