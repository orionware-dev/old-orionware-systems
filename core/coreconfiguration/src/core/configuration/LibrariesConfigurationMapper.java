package core.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LibrariesConfigurationMapper extends ConfigurationMapper
{
    public static ConcurrentMap<String, Boolean> LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER;
    public static ConcurrentMap<String, Boolean> LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER;
    
    
    static
    {
        LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER = new ConcurrentHashMap<String, Boolean>();
        LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER = new ConcurrentHashMap<String, Boolean>();
    }
}