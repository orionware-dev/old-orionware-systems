package core.configuration.classpath.tasks;

import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.DefaultConfigurationEnum;
import core.configuration.OrionConfigurationTask;

public class GetConfigurationPathTask extends ConfigurationObject implements OrionConfigurationTask
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