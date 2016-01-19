package core.annotations.filestream.tasks;

import java.io.File;
import java.io.InputStream;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.filestream.AnnotationsFileStreamService;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask implements OrionTask
{
    public InputStream run(AnnotationsFileStreamService annotationsFileStreamService, GetClasspathRootPathTask getClasspathRootTask, String libraryAnnotationsFilePath, String libraryName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new File((String)getClasspathRootTask.run(libraryName)).getAbsolutePath());
        sb.append(libraryAnnotationsFilePath);
        return annotationsFileStreamService.getFileStream(sb.toString());
    }
}