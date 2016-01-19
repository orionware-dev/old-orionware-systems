package core.configuration.tasks;

import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    public String run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        CoreConfiguration coreConfiguration = new CoreConfiguration();
        StringBuilder sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(coreConfiguration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }
}