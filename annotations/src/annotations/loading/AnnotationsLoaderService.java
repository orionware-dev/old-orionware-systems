package annotations.loading;

import java.io.InputStream;
import annotations.AnnotationService;

public interface AnnotationsLoaderService extends AnnotationService
{
    public InputStream getAnnotationsDefinitionFileStream(String libraryAnnotationsDefinitionFilePath);
}