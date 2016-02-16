package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.OrionSimpleObject;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.tasks.GetClasspathRootPathTask;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.ConfigurationRegistry;
import core.configuration.registry.PropertiesRegistrationService;

public class UpdatePropertyTask extends OrionSimpleObject implements OrionConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.updateProp(key, value);
    }
}