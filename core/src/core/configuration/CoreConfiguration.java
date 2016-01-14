package core.configuration;

import java.util.HashMap;
import java.util.Map;
import core.general.OrionConfiguration;

public class CoreConfiguration extends OrionConfiguration
{
    public static String BIN_DIR = "bin";
    public static String DEFAULT_CONFIGURATION_DIR = "configuration";
    public static String CORE_LIBRARY_NAME = "core";
    public static String CORE_PROPERTIES_FILE_PATH = "/configuration/Core.prop";
    public static String CORE_ANNOTATIONS_DEFINITION_FILE_PATH = "/configuration/CoreAnnotations.prop";
    
    //classpath dirs
    public static String CORE_CLASSPATH_ROOT = "core";
    public static String CORE_INTEGRATION_TESTS_CLASSPATH_ROOT = "coreintegrationtests";
    public static String CORE_UNIT_TESTS_CLASSPATH_ROOT = "coreunittests";
}