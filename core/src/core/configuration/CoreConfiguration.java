package core.configuration;

import core.general.OrionConfiguration;

public class CoreConfiguration extends OrionConfiguration
{
    public String BIN_DIR;
    public String DEFAULT_CONFIGURATION_DIR;
    public String LIBRARY_NAME;
    public String PROPERTIES_FILE_PATH;
    public String ANNOTATIONS_DEFINITION_FILE_PATH;
    
    //classpath dirs
    public String CLASSPATH_ROOT = LIBRARY_NAME;
    public String INTEGRATION_TESTS_CLASSPATH_ROOT;
    public String UNIT_TESTS_CLASSPATH_ROOT;
    
    
    public CoreConfiguration()
    {
        BIN_DIR = "bin";
        DEFAULT_CONFIGURATION_DIR = "configuration";
        LIBRARY_NAME = "core";
        PROPERTIES_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/Core.prop";
        ANNOTATIONS_DEFINITION_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/CoreAnnotations.prop";
        CLASSPATH_ROOT = LIBRARY_NAME;
        INTEGRATION_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "integrationtests";
        UNIT_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "unittests";
    }
}