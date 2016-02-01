package core.annotations.configuration.tasks;

import java.io.InputStream;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask implements OrionTask
{
    private StringBuilder sb = new StringBuilder();
    
    
    public InputStream run(AnnotationsConfigurationService annotationsConfigurationService, GetClasspathRootPathTask getClasspathRootTask, String libraryAnnotationsFilePath, String libraryName)
    {
        sb.append(getClasspathRootTask.run(libraryName));
        sb.append(libraryAnnotationsFilePath);
        return annotationsConfigurationService.getFileStream(sb.toString());
    }
}