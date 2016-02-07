package core.annotations.loader;

import java.io.InputStream;
import core.annotations.loader.filestream.GetAnnotationsFileStreamHelper;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private GetAnnotationsFileStreamHelper getAnnotationsFileStreamHelper = new GetAnnotationsFileStreamHelper();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamHelper.run(libraryName, libraryAnnotationsFilePath);
    }
}