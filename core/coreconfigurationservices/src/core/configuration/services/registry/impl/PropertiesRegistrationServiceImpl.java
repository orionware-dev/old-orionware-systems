package core.configuration.services.registry.impl;

import core.configuration.services.ConfigurationServiceObject;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.tasks.DeletePropertyTask;
import core.configuration.services.registry.impl.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.services.registry.impl.tasks.RegisterPropertyTask;
import core.configuration.services.registry.impl.tasks.SetPropertiesAsRegisteredForLibraryTask;
import core.configuration.services.registry.impl.tasks.UpdatePropertyTask;

public class PropertiesRegistrationServiceImpl extends ConfigurationServiceObject implements PropertiesRegistrationService
{
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName)
    {
        return new HavePropertiesBeenRegisteredForLibraryTask().run(libraryName);
    }

    
    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setPropertiesAsRegisteredForLibrary(String libraryName)
    {
        new SetPropertiesAsRegisteredForLibraryTask().run(libraryName);
    }
    
    
    @Override
    public void registerProp(String key, String value)
    {
        new RegisterPropertyTask().run(key, value);
    }
    
    
    @Override
    public void updateProp(String key, String value)
    {
        new UpdatePropertyTask().run(key, value);
    }
    
    
    @Override
    public void deleteProp(String key)
    {
        new DeletePropertyTask().run(key);
    }
}