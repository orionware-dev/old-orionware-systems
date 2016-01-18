package projectname.configuration;

import core.general.OrionConfiguration;

public class ProjectNameConfiguration extends OrionConfiguration
{
    public static String BIN_DIR = "bin";
    public static String DEFAULT_CONFIGURATION_DIR = "configuration";
    public static String LIBRARY_NAME = "<project_name>";
    public static String PROPERTIES_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/<project_name>.prop";
    public static String ANNOTATIONS_DEFINITION_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/<project_name>Annotations.prop";
    
    //classpath dirs
    public static String CLASSPATH_ROOT = LIBRARY_NAME;
    public static String INTEGRATION_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "integrationtests";
    public static String UNIT_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "unittests";
}