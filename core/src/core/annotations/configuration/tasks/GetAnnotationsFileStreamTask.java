package core.annotations.configuration.tasks;

import java.io.File;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.tasks.GetClasspathRootTask;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    private String libraryAnnotationsFilePath;
    private GetClasspathRootTask getClasspathRootTask;
    
    
    public GetAnnotationsFileStreamTask(AnnotationsConfigurationService annotationsConfigurationService, GetClasspathRootTask getClasspathRootTask, String libraryAnnotationsFilePath)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        this.getClasspathRootTask = getClasspathRootTask;
        this.libraryAnnotationsFilePath = libraryAnnotationsFilePath;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        return annotationsConfigurationService.getFileSystemService().getFileStream(new File((String)getClasspathRootTask.execute()).getAbsolutePath() + libraryAnnotationsFilePath);
    }


    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}