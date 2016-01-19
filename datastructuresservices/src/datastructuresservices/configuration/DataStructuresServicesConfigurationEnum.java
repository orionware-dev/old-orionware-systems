package datastructuresservices.configuration;

import core.general.OrionConfigurationEnum;

public enum DataStructuresServicesConfigurationEnum implements OrionConfigurationEnum
{
    LIBRARY_NAME("datastructuresservices"),
    //PROPERTIES_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructures.prop"),
    //ANNOTATIONS_DEFINITION_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/DataStructuresAnnotations.prop"),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    CLASSPATH_ROOT("" + LIBRARY_NAME.get()),
    INTEGRATION_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "unittests");
    
    
    private final String dataStructuresServicesConfigurationValue;
    
    
    private DataStructuresServicesConfigurationEnum(String dataStructuresServicesConfigurationValue)
    {
        this.dataStructuresServicesConfigurationValue = dataStructuresServicesConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresServicesConfigurationValue;
    }
}