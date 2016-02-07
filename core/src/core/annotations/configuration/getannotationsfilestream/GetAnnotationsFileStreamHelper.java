package core.annotations.configuration.getannotationsfilestream;

import java.io.InputStream;
import core.annotations.configuration.getannotationsfilestream.tasks.GetAnnotationsFileStreamTask;
import core.configuration.tasks.GetCoreClasspathRootPathTask;
import core.services.OrionServiceHelper;

public class GetAnnotationsFileStreamHelper implements OrionServiceHelper
{
    private GetCoreClasspathRootPathTask getCoreClasspathRootTask = new GetCoreClasspathRootPathTask();
    private GetAnnotationsFileStreamTask getAnnotationsFileStreamTask = new GetAnnotationsFileStreamTask();
    
    
    public InputStream run(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamTask.run(getCoreClasspathRootTask.run(libraryName), libraryAnnotationsFilePath, libraryName);
    }
}