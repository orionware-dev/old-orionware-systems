package core.configuration.services.classpath;

import java.util.List;
import core.configuration.ConfigurationEntries;
import core.configuration.ConfigurationEntry;
import core.configuration.ConfigurationService;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);


    public boolean isCoreLibrary(Object objectBeingRun);


    public void loadLibrariesProperties();


    @SuppressWarnings("rawtypes")
    public ConfigurationEntries getConfigurationEntries();


    public List<ConfigurationEntry<Object, Object>> getConfigurationEntriesAsList();
}