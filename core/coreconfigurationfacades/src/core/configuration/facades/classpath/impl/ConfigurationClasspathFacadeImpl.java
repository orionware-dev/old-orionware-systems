package core.configuration.facades.classpath.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
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
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        configurationClasspathService.loadLibrariesProperties(librariesConfiguration);
    }

    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return configurationClasspathService.getFileStream(filePath);
    }

    
    @Override
    public void closeResource(Closeable stream)
    {
        configurationClasspathService.closeResource(stream);
    }
}