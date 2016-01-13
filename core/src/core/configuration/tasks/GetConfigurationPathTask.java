package core.configuration.tasks;

import core.configuration.Configuration;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    public Object run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        StringBuilder sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(Configuration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }
}