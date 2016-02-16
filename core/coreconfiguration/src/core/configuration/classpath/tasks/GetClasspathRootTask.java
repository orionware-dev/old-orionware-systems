package core.configuration.classpath.tasks;

import java.io.File;
import core.OrionSimpleObject;
import core.configuration.OrionConfigurationTask;

public class GetClasspathRootTask extends OrionSimpleObject implements OrionConfigurationTask
{
    public File run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        return new File(getClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}