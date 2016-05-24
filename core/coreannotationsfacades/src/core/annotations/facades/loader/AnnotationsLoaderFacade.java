package core.annotations.facades.loader;

import java.io.InputStream;
import core.services.OrionFacade;

public interface AnnotationsLoaderFacade extends OrionFacade
{
    public InputStream getAnnotationsFileStream(String libraryAnnotationsFilePath);
}