package core.configuration.tasks;

import java.io.File;
import core.services.OrionTask;

public class GetCoreClasspathRootTask implements OrionTask
{
    public File run(String libraryClasspathRootPath, GetCoreClasspathRootPathTask getCoreClasspathRootPathTask)
    {
        return new File(getCoreClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}