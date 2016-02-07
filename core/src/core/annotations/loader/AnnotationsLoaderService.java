package core.annotations.loader;

import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface AnnotationsLoaderService extends OrionService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
}