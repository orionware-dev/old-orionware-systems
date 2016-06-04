package core.configuration;

public enum CoreConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("coreconfiguration"),
    LIBRARY_CLASS_PATH("/core/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    CONFIGURATION_FILE_PATH("" + LIBRARY_CLASS_PATH.get() + "/CoreConfiguration.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CLASS_PATH.get() + "/CoreConfigurationAnnotations.prop");
    
    
    private final String coreConfigurationValue;
    
    
    private CoreConfigurationEnumeration(String coreConfigurationValue)
    {
        this.coreConfigurationValue = coreConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return coreConfigurationValue;
    }
}