package core.configuration;

import core.abstraction.ConfigurationEnumeration;

public enum DefaultConfigurationEnumeration implements ConfigurationEnumeration
{
    DEFAULT_CONFIGURATION_DIR("configuration"),
    DEFAULT_INTEGRATION_TESTS_DIR("integrationtests"),
    DEFAULT_UNIT_TESTS_DIR("unittests");

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