package core.annotations.facades.loader.impl;

import java.io.InputStream;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.loader.AnnotationsLoaderFacade;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.AnnotationsLoaderServiceImpl;

public class AnnotationsLoaderFacadeImpl extends AnnotationFacadeObject implements AnnotationsLoaderFacade
{
    private AnnotationsLoaderService annotationsLoaderService;
    
    
    public AnnotationsLoaderFacadeImpl()
    {
        this.annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryAnnotationsFilePath)
    {
        return annotationsLoaderService.getAnnotationsDefinitionFileStream(libraryAnnotationsFilePath);
    }
}