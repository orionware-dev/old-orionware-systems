package datastructures.facades.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DataStructuresFacadesConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructures/facades"),
    LIBRARY_CLASS_PATH("/" + LIBRARY_NAME.get()),
    LIBRARY_CONFIGURATION_DIR(""),
    CONFIGURATION_FILE_NAME(""),
    CONFIGURATION_FILE_PATH(""),
    ANNOTATIONS_DEFINITION_FILE_NAME(""),
    ANNOTATIONS_DEFINITION_FILE_PATH(""),
    INTEGRATION_TESTS_CLASS_PATH(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASS_PATH(LIBRARY_NAME.get() + "unittests");
    
    
    private final String dataStructuresFacadesConfigurationValue;
    
    
    private DataStructuresFacadesConfigurationEnumeration(String dataStructuresFacadesConfigurationValue)
    {
        this.dataStructuresFacadesConfigurationValue = dataStructuresFacadesConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresFacadesConfigurationValue;
    }
}