package core.configuration.tasks;

import core.general.DefaultConfigurationEnum;
import core.services.OrionTask;

public class GetCoreConfigurationPathTask implements OrionTask
{
    private StringBuilder sb = new StringBuilder();
    
    
    public String run(String libraryClasspathRootPath, GetCoreClasspathRootPathTask getCoreClasspathRootPathTask)
    {
        sb.append((String)getCoreClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get());
        return sb.toString();
    }
}