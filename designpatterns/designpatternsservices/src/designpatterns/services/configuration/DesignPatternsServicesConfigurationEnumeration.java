package designpatterns.services.configuration;

import core.configuration.ConfigurationEnumeration;

public enum DesignPatternsServicesConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("designpatterns/services"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get()),
    LIBRARY_CONFIGURATION_DIR(""),
    CONFIGURATION_FILE_NAME(""),
    CONFIGURATION_FILE_PATH(""),
    ANNOTATIONS_DEFINITION_FILE_NAME(""),
    ANNOTATIONS_DEFINITION_FILE_PATH(""),
    INTEGRATION_TESTS_CLASS_PATH(""),
    UNIT_TESTS_CLASS_PATH("");

    private final String designPatternsServicesConfigurationValue;


    private DesignPatternsServicesConfigurationEnumeration(String designPatternsServicesConfigurationValue)
    {
        this.designPatternsServicesConfigurationValue = designPatternsServicesConfigurationValue;
    }


    @Override
    public String get()
    {
        return designPatternsServicesConfigurationValue;
    }
}