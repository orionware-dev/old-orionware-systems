package core.configuration;

public enum CoreConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("coreconfiguration"),
    LIBRARY_CLASS_PATH("/core"),
    LIBRARY_CONFIGURATION_DIR("" + LIBRARY_CLASS_PATH.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    // put an empty string as a prefix, because it complaints that there
    // is no constructor with argument of type CoreConfigurationEnum
    CONFIGURATION_FILE_NAME("CoreConfiguration.prop"),
    CONFIGURATION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_NAME("CoreConfigurationAnnotations.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    INTEGRATION_TESTS_CLASS_PATH(""), UNIT_TESTS_CLASS_PATH("");

    // /core/configuration/CoreConfigurationAnnotations.prop
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