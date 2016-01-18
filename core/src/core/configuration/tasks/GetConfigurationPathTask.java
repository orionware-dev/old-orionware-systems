package core.configuration.tasks;

import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    public String run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        StringBuilder sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(CoreConfiguration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }
}