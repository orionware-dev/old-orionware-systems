package core.annotations.facades;

import java.io.InputStream;
import core.services.OrionFacade;

public interface AnnotationsLoaderFacade extends OrionFacade
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);
}