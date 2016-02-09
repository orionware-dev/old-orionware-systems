package core.configuration.classpath.tasks;

import java.io.File;
import core.configuration.OrionConfigurationTask;

public class GetCoreClasspathRootTask implements OrionConfigurationTask
{
    public File run(String libraryClasspathRootPath, GetCoreClasspathRootPathTask getCoreClasspathRootPathTask)
    {
        return new File(getCoreClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}