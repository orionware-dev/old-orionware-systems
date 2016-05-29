package core.annotations.facades.loader;

import java.io.InputStream;
import core.annotations.AnnotationFacade;
import core.services.OrionFacade;

public interface AnnotationsLoaderFacade extends AnnotationFacade
{
    public InputStream getAnnotationsFileStream(String libraryAnnotationsFilePath);
}