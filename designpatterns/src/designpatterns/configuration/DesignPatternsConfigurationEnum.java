package designpatterns.configuration;

import core.general.DefaultConfigurationEnum;
import core.general.OrionConfigurationEnum;

public enum DesignPatternsConfigurationEnum implements OrionConfigurationEnum
{
    LIBRARY_NAME("designpatterns"),
    PROPERTIES_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/Pipeline.prop"),
    //ANNOTATIONS_DEFINITION_FILE_PATH("/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get() + "/CoreAnnotations.prop"),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    CLASSPATH_ROOT("" + LIBRARY_NAME.get()),
    INTEGRATION_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "integrationtests"),
    UNIT_TESTS_CLASSPATH_ROOT(LIBRARY_NAME.get() + "unittests");
    
    
    private final String designPatternsConfigurationValue;
    
    
    private DesignPatternsConfigurationEnum(String designPatternsConfigurationValue)
    {
        this.designPatternsConfigurationValue = designPatternsConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return designPatternsConfigurationValue;
    }
}