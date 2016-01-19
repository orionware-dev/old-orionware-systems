package core.annotations.filestream;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface AnnotationsFileStreamService extends OrionService
{
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath);


    public InputStream getFileStream(String filePath);


    public void closeResource(Closeable stream);
}