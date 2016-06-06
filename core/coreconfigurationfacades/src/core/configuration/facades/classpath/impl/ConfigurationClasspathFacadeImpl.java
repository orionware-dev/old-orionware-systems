package core.configuration.facades.classpath.impl;

import core.configuration.facades.ConfigurationFacadeObject;
import core.configuration.facades.classpath.ConfigurationClasspathFacade;
import core.configuration.services.classpath.ConfigurationClasspathService;
import core.configuration.services.classpath.impl.ConfigurationClasspathServiceImpl;

public class ConfigurationClasspathFacadeImpl extends ConfigurationFacadeObject implements ConfigurationClasspathFacade
{
    private ConfigurationClasspathService configurationClasspathService;
    
    
    public ConfigurationClasspathFacadeImpl()
    {
        this.configurationClasspathService = new ConfigurationClasspathServiceImpl();
    }
    
    
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return configurationClasspathService.isCoreLibrary(classBeingRun);
    }

    
    @Override
    public void loadLibrariesProperties()
    {
        configurationClasspathService.loadLibrariesProperties();
    }
}