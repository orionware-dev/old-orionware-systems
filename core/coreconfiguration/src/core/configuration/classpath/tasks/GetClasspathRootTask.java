package core.configuration.classpath.tasks;

import java.io.File;
import core.configuration.ConfigurationObject;
import core.configuration.OrionConfigurationTask;

public class GetClasspathRootTask extends ConfigurationObject implements OrionConfigurationTask
{
    public File run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        return new File(getClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}