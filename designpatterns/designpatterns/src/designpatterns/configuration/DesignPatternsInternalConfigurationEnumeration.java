package designpatterns.configuration;

import core.configuration.ConfigurationEnumeration;
import core.configuration.DefaultConfigurationEnumeration;

public enum DesignPatternsInternalConfigurationEnumeration implements ConfigurationEnumeration
{
    PIPELINE_CONFIGURATION_FILE_NAME("Pipeline.prop"),
    PIPELINE_CONFIGURATION_FILE_PATH("" + DesignPatternsConfigurationEnumeration.LIBRARY_CLASS_PATH.get() + "/" + DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get() + "/" + PIPELINE_CONFIGURATION_FILE_NAME.get());
    
    
    private final String dataStructuresConfigurationValue;
    
    
    private DesignPatternsInternalConfigurationEnumeration(String dataStructuresConfigurationValue)
    {
        this.dataStructuresConfigurationValue = dataStructuresConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return dataStructuresConfigurationValue;
    }
}