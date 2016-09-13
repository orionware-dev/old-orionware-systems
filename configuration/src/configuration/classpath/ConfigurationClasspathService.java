package configuration.classpath;

import java.util.List;
import configuration.ConfigurationEntries;
import configuration.ConfigurationEntry;
import configuration.ConfigurationService;

public interface ConfigurationClasspathService extends ConfigurationService
{
    public void loadLibrariesProperties();


    @SuppressWarnings("rawtypes")
    public ConfigurationEntries getConfigurationEntries();


    public List<ConfigurationEntry<Object, Object>> getConfigurationEntriesAsList();
}