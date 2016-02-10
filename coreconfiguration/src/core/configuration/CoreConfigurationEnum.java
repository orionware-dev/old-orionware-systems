package core.configuration;

public enum CoreConfigurationEnum implements OrionConfigurationEnum
{
    LIBRARY_NAME("core"),
    PROPERTIES_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/Core.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/CoreAnnotations.prop"),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    CLASSPATH_ROOT("" + LIBRARY_NAME.get());
    
    
    private final String coreConfigurationValue;
    
    
    private CoreConfigurationEnum(String coreConfigurationValue)
    {
        this.coreConfigurationValue = coreConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return coreConfigurationValue;
    }
}