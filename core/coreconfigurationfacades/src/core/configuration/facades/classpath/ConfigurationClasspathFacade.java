package core.configuration.facades.classpath;

import core.configuration.ConfigurationEntries;
import core.configuration.ConfigurationFacade;

public interface ConfigurationClasspathFacade extends ConfigurationFacade
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public boolean isCoreLibrary(Object objectBeingRun);
    
    
    public void loadLibrariesProperties();
    
    
    @SuppressWarnings("rawtypes")
    public ConfigurationEntries getConfigurationEntries();
}