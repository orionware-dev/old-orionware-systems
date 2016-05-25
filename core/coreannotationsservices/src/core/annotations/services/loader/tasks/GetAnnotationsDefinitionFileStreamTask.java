package core.annotations.services.loader.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.loader.tasks.functions.GetAnnotationsDefinitionFileStreamFunction;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    private GetAnnotationsDefinitionFileStreamFunction getAnnotationsDefinitionFileStreamFunction;
    
    
    public GetAnnotationsDefinitionFileStreamTask()
    {
        this.getAnnotationsDefinitionFileStreamFunction = new GetAnnotationsDefinitionFileStreamFunction();
    }
    
    
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return getAnnotationsDefinitionFileStreamFunction.run(libraryAnnotationsDefinitionFilePath);
    }
}