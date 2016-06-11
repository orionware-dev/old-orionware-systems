package designpatterns.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DesignPatternsConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("designpatterns"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get()),
    LIBRARY_CONFIGURATION_DIR("" + LIBRARY_CLASS_PATH.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME("DesignPatterns.prop"),
    CONFIGURATION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_NAME("DesignPatternsAnnotations.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    INTEGRATION_TESTS_CLASS_PATH(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_INTEGRATION_TESTS_DIR.get()),
    UNIT_TESTS_CLASS_PATH(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_UNIT_TESTS_DIR.get());
    
    
    private final String dataStructuresConfigurationValue;
    
    
    private DesignPatternsConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}