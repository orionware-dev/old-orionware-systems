package core.configuration.tasks;

import core.general.DefaultConfigurationEnum;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    private StringBuilder sb = new StringBuilder();
    
    
    public String run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        sb.append((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get());
        return sb.toString();
    }
}