package core.annotations.loader;

import java.io.InputStream;
import core.services.OrionService;

public interface AnnotationsLoaderService extends OrionService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
}