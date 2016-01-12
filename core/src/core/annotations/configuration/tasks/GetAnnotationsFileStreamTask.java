package core.annotations.configuration.tasks;

import java.io.File;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.tasks.GetClasspathRootTask;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask extends OrionTask
{
    public Object run(AnnotationsConfigurationService annotationsConfigurationService, GetClasspathRootTask getClasspathRootTask, String libraryAnnotationsFilePath, String libraryName)
    {
        return annotationsConfigurationService.getFileSystemService().getFileStream(new File((String)getClasspathRootTask.run(libraryName)).getAbsolutePath() + libraryAnnotationsFilePath);
    }
}