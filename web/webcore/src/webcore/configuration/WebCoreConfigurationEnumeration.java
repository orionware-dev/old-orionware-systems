package webcore.configuration;

import configuration.DefaultConfigurationEnumeration;
import core.abstraction.ConfigurationEnumeration;

public enum WebCoreConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("webcore"),
    LIBRARY_CLASS_PATH("/webcore"),
    LIBRARY_CONFIGURATION_DIR("" + LIBRARY_CLASS_PATH.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME("WebCore.prop"),
    CONFIGURATION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + CONFIGURATION_FILE_NAME.get()),
    ANNOTATIONS_DEFINITION_FILE_NAME("WebCoreAnnotations.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    INTEGRATION_TESTS_CLASS_PATH(""),
    UNIT_TESTS_CLASS_PATH("");

    private final String dataStructuresConfigurationValue;


    private WebCoreConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }


    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}