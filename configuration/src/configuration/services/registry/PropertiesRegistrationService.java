package configuration.services.registry;

import configuration.ConfigurationService;
import configuration.LibraryConfiguration;
import core.tuples.KeyValuePair;

public interface PropertiesRegistrationService extends ConfigurationService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);


    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);


    public boolean havePropertiesNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public void setPropertiesAsRegisteredForLibrary(String libraryName);


    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public void registerProp(String key, String value);


    public void registerProp(KeyValuePair<String, String> keyValuePair);


    public void updateProp(String key, String value);


    public void updateProp(KeyValuePair<String, String> keyValuePair);


    public void deleteProp(String key);
}