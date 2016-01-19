package core.configuration.tasks;

import core.general.DefaultConfigurationEnum;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    public String run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        StringBuilder sb = new StringBuilder();
        sb.append((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get());
        return sb.toString();
    }
}