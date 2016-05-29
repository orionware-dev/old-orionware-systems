package core.annotations.facades.loader;

import java.io.InputStream;
import core.annotations.AnnotationFacade;

public interface AnnotationsLoaderFacade extends AnnotationFacade
{
    public InputStream getAnnotationsFileStream(String libraryAnnotationsFilePath);
}