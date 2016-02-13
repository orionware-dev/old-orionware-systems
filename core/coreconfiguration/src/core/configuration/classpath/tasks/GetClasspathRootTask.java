package core.configuration.classpath.tasks;

import java.io.File;
import core.configuration.OrionConfigurationTask;

public class GetClasspathRootTask implements OrionConfigurationTask
{
    public File run(String libraryClasspathRootPath, GetClasspathRootPathTask getCoreClasspathRootPathTask)
    {
        return new File(getCoreClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}