package datastructures.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DataStructuresConfigurationEnum implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructures"),
    CONFIGURATION_FILE_PATH("/datastructures/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructures.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("/datastructures/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructuresAnnotations.prop"),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    CLASSPATH_ROOT("" + LIBRARY_NAME.get()),
    INTEGRATION_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "unittests");
    
    
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