package datastructures.services.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DataStructuresServicesConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructures/servicess"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME(""),
    CONFIGURATION_FILE_PATH(""),
    ANNOTATIONS_DEFINITION_FILE_NAME(""),
    ANNOTATIONS_DEFINITION_FILE_PATH(""),
    INTEGRATION_TESTS_CLASS_PATH(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASS_PATH(LIBRARY_NAME.get() + "unittests");
    
    
    private final String dataStructuresServicesConfigurationValue;
    
    
    private DataStructuresServicesConfigurationEnumeration(String dataStructuresServicesConfigurationValue)
    {
        this.dataStructuresServicesConfigurationValue = dataStructuresServicesConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresServicesConfigurationValue;
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Enum[] getEnumerationValues()
    {
        return values();
    }
}