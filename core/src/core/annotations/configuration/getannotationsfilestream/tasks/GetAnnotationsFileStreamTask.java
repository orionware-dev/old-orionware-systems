package core.annotations.configuration.getannotationsfilestream.tasks;

import java.io.InputStream;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.services.OrionTask;

public class GetAnnotationsFileStreamTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
    
    
    public InputStream run(String classpathRoot, String libraryAnnotationsFilePath, String libraryName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return annotationsConfigurationService.getFileStream(sb.toString());
    }
}