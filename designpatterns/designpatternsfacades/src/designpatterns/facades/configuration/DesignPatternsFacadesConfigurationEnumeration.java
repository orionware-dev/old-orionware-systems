package designpatterns.facades.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DesignPatternsFacadesConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("designpatterns/facades"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME(""),
    CONFIGURATION_FILE_PATH(""),
    ANNOTATIONS_DEFINITION_FILE_NAME(""),
    ANNOTATIONS_DEFINITION_FILE_PATH(""),
    INTEGRATION_TESTS_CLASS_PATH(""),
    UNIT_TESTS_CLASS_PATH("");
    
    
    private final String dataStructuresConfigurationValue;
    
    
    private DesignPatternsFacadesConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}