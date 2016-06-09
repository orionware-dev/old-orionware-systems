package datastructures.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DataStructuresConfigurationEnum implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructures"),
    CONFIGURATION_FILE_NAME("DataStructures.prop"),
    ANNOTATIONS_DEFINITION_FILE_NAME("DataStructures.prop"),
    CONFIGURATION_FILE_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_PATH("/" + LIBRARY_NAME.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    INTEGRATION_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_INTEGRATION_TESTS_DIR.get()),
    UNIT_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + DefaultConfigurationEnumeration.DEFAULT_UNIT_TESTS_DIR.get());
    
    
    private final String dataStructuresConfigurationValue;
    
    
    private DataStructuresConfigurationEnum(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}