package core.configuration.facades.classpath;

import core.configuration.ConfigurationFacade;

public interface ConfigurationClasspathFacade extends ConfigurationFacade
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
    
    
    public void loadLibrariesProperties();
}