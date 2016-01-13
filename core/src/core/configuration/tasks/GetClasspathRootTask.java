package core.configuration.tasks;

import java.io.File;
import core.services.OrionTask;

public class GetClasspathRootTask implements OrionTask
{
    public Object run(String libraryClasspathRootPath, GetClasspathRootPathTask getClasspathRootPathTask)
    {
        return new File((String)getClasspathRootPathTask.run(libraryClasspathRootPath));
    }
}