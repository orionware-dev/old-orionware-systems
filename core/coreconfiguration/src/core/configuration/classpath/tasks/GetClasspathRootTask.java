package core.configuration.classpath.tasks;

import java.io.File;
import core.configuration.OrionConfigurationTask;

public class GetClasspathRootTask implements OrionConfigurationTask
{
    public File run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        return new File(getClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}