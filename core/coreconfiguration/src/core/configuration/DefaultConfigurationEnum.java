package core.configuration;

public enum DefaultConfigurationEnum implements ConfigurationEnum
{
    DEFAULT_CONFIGURATION_DIR("configuration");
    
    
    private final String defaultConfigurationValue;
    
    
    private DefaultConfigurationEnum(String defaultConfigurationValue)
    {
        this.defaultConfigurationValue = defaultConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return defaultConfigurationValue;
    }
}