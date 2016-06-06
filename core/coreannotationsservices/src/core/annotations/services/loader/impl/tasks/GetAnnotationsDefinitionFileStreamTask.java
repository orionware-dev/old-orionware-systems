package core.annotations.services.loader.impl.tasks;

import java.io.InputStream;
import java.util.function.Function;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GetAnnotationsDefinitionFileStreamTask extends AnnotationServiceObject implements AnnotationTask
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath, Function<String, InputStream> getFileStreamMethod)
    {
        return getFileStreamMethod.apply(libraryAnnotationsDefinitionFilePath);
    }
}