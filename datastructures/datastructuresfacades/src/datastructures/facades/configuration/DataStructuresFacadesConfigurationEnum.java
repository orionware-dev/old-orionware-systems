package datastructures.facades.configuration;

import core.configuration.ConfigurationEnumeration;

public enum DataStructuresFacadesConfigurationEnum implements ConfigurationEnumeration
{
    LIBRARY_NAME("datastructuresfacades"),
    //CONFIGURATION_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructures.prop"),
    //ANNOTATIONS_DEFINITION_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructuresAnnotations.prop"),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    CLASSPATH_ROOT("" + LIBRARY_NAME.get()),
    INTEGRATION_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "unittests");
    
    
    private final String dataStructuresFacadesConfigurationValue;
    
    
    private DataStructuresFacadesConfigurationEnum(String dataStructuresFacadesConfigurationValue)
    {
        this.dataStructuresFacadesConfigurationValue = dataStructuresFacadesConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresFacadesConfigurationValue;
    }
}