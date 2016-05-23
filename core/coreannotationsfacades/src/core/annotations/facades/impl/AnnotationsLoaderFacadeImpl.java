package core.annotations.facades.impl;

import java.io.InputStream;
import core.annotations.facades.AnnotationsLoaderFacade;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.AnnotationsLoaderServiceImpl;

public class AnnotationsLoaderFacadeImpl implements AnnotationsLoaderFacade
{
    private AnnotationsLoaderService annotationsLoaderService;
    
    
    public AnnotationsLoaderFacadeImpl()
    {
        annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryAnnotationsFilePath)
    {
        return annotationsLoaderService.getAnnotationsFileStream(libraryAnnotationsFilePath);
    }
}