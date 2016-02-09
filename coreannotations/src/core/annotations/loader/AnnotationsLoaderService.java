package core.annotations.loader;

import java.io.InputStream;
import core.annotations.OrionAnnotationService;

public interface AnnotationsLoaderService extends OrionAnnotationService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
}