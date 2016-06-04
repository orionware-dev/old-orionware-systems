package core.configuration;

public enum DefaultConfigurationEnumeration implements ConfigurationEnumeration
{
    DEFAULT_CONFIGURATION_DIR("configuration");
    
    
    private final String defaultConfigurationValue;
    
    
    private DefaultConfigurationEnumeration(String defaultConfigurationValue)
    {
        this.defaultConfigurationValue = defaultConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return defaultConfigurationValue;
    }
}