package core.configuration.facades.classpath.impl;

import java.util.List;
import core.configuration.ConfigurationEntries;
import core.configuration.ConfigurationEntry;
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
    public boolean isCoreLibrary(Object objectBeingRun)
    {
        return configurationClasspathService.isCoreLibrary(objectBeingRun);
    }

    
    @Override
    public void loadLibrariesProperties()
    {
        configurationClasspathService.loadLibrariesProperties();
    }


    @SuppressWarnings("rawtypes")
    @Override
    public ConfigurationEntries getConfigurationEntries()
    {
        return configurationClasspathService.getConfigurationEntries();
    }
    
    
    @Override
    public List<ConfigurationEntry<Object, Object>> getConfigurationEntriesAsList()
    {
        return configurationClasspathService.getConfigurationEntriesAsList();
    }
}