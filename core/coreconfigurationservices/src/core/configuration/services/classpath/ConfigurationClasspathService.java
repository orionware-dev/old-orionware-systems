package core.configuration.services.classpath;

import core.configuration.ConfigurationService;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties();
}