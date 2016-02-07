package core.annotations.configuration.getannotationsfilestream;

import java.io.InputStream;
import core.annotations.configuration.getannotationsfilestream.tasks.GetAnnotationsFileStreamTask;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.services.OrionServiceHelper;

public class GetAnnotationsFileStreamHelper implements OrionServiceHelper
{
    private GetClasspathRootPathTask getClasspathRootTask = new GetClasspathRootPathTask();
    private GetAnnotationsFileStreamTask getAnnotationsFileStreamTask = new GetAnnotationsFileStreamTask();
    
    
    public InputStream run(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamTask.run(getClasspathRootTask.run(libraryName), libraryAnnotationsFilePath, libraryName);
    }
}