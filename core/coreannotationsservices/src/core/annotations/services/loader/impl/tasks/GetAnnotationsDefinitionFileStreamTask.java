package core.annotations.services.loader.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.functions.Function1x1;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath, Function1x1<String, InputStream> getFileStreamMethod)
    {
        return getFileStreamMethod.run(libraryAnnotationsDefinitionFilePath);
    }
}