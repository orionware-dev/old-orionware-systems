package configuration.registry;

import configuration.ConfigurationService;
import configuration.LibraryConfiguration;
import core.tuples.KeyValuePair;

public interface PropertiesRegistrationService extends ConfigurationService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryClassPath);


    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryClassPath);


    public boolean havePropertiesNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public boolean haveConfigurationBeenRegisteredForLibrary(String libraryClassPath);


    public boolean haveConfigurationBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public boolean haveConfigurationNotBeenRegisteredForLibrary(String libraryClassPath);


    public boolean haveConfigurationNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public void setPropertiesAsRegisteredForLibrary(String libraryClassPath);


    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public void setConfigurationAsRegisteredForLibrary(String libraryClassPath);


    public void setConfigurationAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration);


    public void registerProp(String key, String value);


    public void registerProp(KeyValuePair<String, String> keyValuePair);


    public void updateProp(String key, String value);


    public void updateProp(KeyValuePair<String, String> keyValuePair);


    public void deleteProp(String key);
}