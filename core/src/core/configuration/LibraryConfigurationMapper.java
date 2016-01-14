package core.configuration;

import java.util.HashMap;
import java.util.Map;
import core.general.OrionMapper;

public class LibraryConfigurationMapper extends OrionMapper
{
    public static Map<String, Boolean> LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER;
    public static Map<String, Boolean> LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER;
    
    
    static
    {
        LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_LOADED_MAPPER = new HashMap<String, Boolean>();
        LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER = new HashMap<String, Boolean>();
    }
}