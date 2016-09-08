package core.dependencyinjection.configuration;

import core.abstraction.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum CoreDependencyInjectionConfigurationEnumeration implements ConfigurationEnumeration
{
    LIBRARY_NAME("core.dependencyinjection"),
    LIBRARY_CLASS_PATH("/core/dependencyinjection"),
    LIBRARY_CONFIGURATION_DIR("" + LIBRARY_CLASS_PATH.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get()),
    CONFIGURATION_FILE_NAME(""),
    CONFIGURATION_FILE_PATH(""),
    ANNOTATIONS_DEFINITION_FILE_NAME("CoreDependencyInjectionAnnotations.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CONFIGURATION_DIR.get() + "/" + ANNOTATIONS_DEFINITION_FILE_NAME.get()),
    INTEGRATION_TESTS_CLASS_PATH(""),
    UNIT_TESTS_CLASS_PATH("");

    private final String dataStructuresConfigurationValue;


    private CoreDependencyInjectionConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }


    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}