package datastructures.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DataStructuresConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructures"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME("DataStructures.prop"),
    CONFIGURATION_FILE_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_NAME("DataStructuresAnnotations.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    INTEGRATION_TESTS_CLASS_PATH(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_INTEGRATION_TESTS_DIR.get()),
    UNIT_TESTS_CLASS_PATH(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_UNIT_TESTS_DIR.get());
    
    
    private final String dataStructuresConfigurationValue;
    
    
    private DataStructuresConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}