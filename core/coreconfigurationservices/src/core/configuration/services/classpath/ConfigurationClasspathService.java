package core.configuration.services.classpath;

import core.configuration.ConfigurationEntries;
import core.configuration.ConfigurationService;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public boolean isCoreLibrary(Object objectBeingRun);
    
    
    public void loadLibrariesProperties();
    
    
    @SuppressWarnings("rawtypes")
    public ConfigurationEntries getConfigurationEntries();
}