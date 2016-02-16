package core.annotations.facades.impl;

import java.io.InputStream;
import core.annotations.facades.AnnotationsFacade;
import core.annotations.facades.AnnotationsLoaderFacade;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.AnnotationsLoaderServiceImpl;

public class AnnotationsLoaderFacadeImpl implements AnnotationsLoaderFacade
{
    private AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return annotationsLoaderService.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
    }
}