package configuration;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import core.abstraction.OrionMapper;

public class LibrariesConfigurationMapper extends OrionMapper
{
    public static boolean coreLibrariesHaveNotBeenRegistered;
    public static ConcurrentMap<String, Boolean> LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER;
    public static ConcurrentMap<String, Boolean> LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER;
    public static ConcurrentMap<String, Boolean> LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER;

    
    static
    {
        coreLibrariesHaveNotBeenRegistered = true;
        LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER = new ConcurrentHashMap<String, Boolean>();
        LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER = new ConcurrentHashMap<String, Boolean>();
        LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER = new ConcurrentHashMap<String, Boolean>();
    }
}