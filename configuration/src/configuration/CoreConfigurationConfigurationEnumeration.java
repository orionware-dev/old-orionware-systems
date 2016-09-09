package configuration;

import core.abstraction.ConfigurationEnumeration;

public enum CoreConfigurationConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("configuration"),
    LIBRARY_CLASS_PATH("/configuration"),
    LIBRARY_CONFIGURATION_DIR("" + LIBRARY_CLASS_PATH.get()),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    CONFIGURATION_FILE_NAME("Configuration.prop"),
    CONFIGURATION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_NAME(""),
    ANNOTATIONS_DEFINITION_FILE_PATH(""),
    INTEGRATION_TESTS_CLASS_PATH(""),
    UNIT_TESTS_CLASS_PATH("");

    
    private final String coreConfigurationValue;


    private CoreConfigurationConfigurationEnumeration(String coreConfigurationValue)
    {
        this.coreConfigurationValue = coreConfigurationValue;
    }


    @Override
    public String get()
    {
        return coreConfigurationValue;
    }
}