package core.configuration.classpath.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.DefaultConfigurationEnum;

public class GetConfigurationPathTask implements OrionConfigurationTask
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