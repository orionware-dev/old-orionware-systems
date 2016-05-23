package core.annotations.services.loader;

import java.io.InputStream;
import core.annotations.AnnotationService;

public interface AnnotationsLoaderService extends AnnotationService
{
    public InputStream getAnnotationsFileStream(String libraryAnnotationsDefinitionFilePath);
}