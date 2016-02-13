package core.configuration.classpath.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.DefaultConfigurationEnum;

public class GetCoreConfigurationPathTask implements OrionConfigurationTask
{
    private StringBuilder sb = new StringBuilder();
    
    
    public String run(String libraryClasspathRootPath, GetClasspathRootPathTask getCoreClasspathRootPathTask)
    {
        sb.append((String)getCoreClasspathRootPathTask.run(libraryClasspathRootPath));
        sb.append("/");
        sb.append(DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get());
        return sb.toString();
    }
}