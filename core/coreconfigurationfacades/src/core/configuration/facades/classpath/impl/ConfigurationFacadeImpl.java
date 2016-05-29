package core.configuration.facades.classpath.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
import core.configuration.facades.ConfigurationFacadeObject;
import core.configuration.facades.classpath.ConfigurationFacade;
import core.configuration.services.classpath.ConfigurationService;
import core.configuration.services.classpath.impl.ConfigurationServiceImpl;

public class ConfigurationFacadeImpl extends ConfigurationFacadeObject implements ConfigurationFacade
{
    private ConfigurationService configurationService;
    
    
    public ConfigurationFacadeImpl()
    {
        this.configurationService = new ConfigurationServiceImpl();
    }
    
    
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return configurationService.isCoreLibrary(classBeingRun);
    }

    
    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        configurationService.loadLibrariesProperties(librariesConfiguration);
    }

    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return configurationService.getFileStream(filePath);
    }

    
    @Override
    public void closeResource(Closeable stream)
    {
        configurationService.closeResource(stream);
    }
}