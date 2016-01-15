package core.configuration.tasks;

import java.io.File;
import core.services.OrionTask;

public class GetClasspathRootTask implements OrionTask
{
    public File run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        return new File(getClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}