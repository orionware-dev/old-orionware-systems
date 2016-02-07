package core.annotations.configuration;

import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.getannotationsfilestream.GetAnnotationsFileStreamHelper;
import core.annotations.configuration.loadlibrariesannotations.LoadLibrariesAnnotationsHelper;
import core.annotations.configuration.registerannotation.RegisterAnnotationHelper;
import core.configuration.LibraryConfiguration;

public class AnnotationsConfigurationServiceImpl implements AnnotationsConfigurationService
{
    private RegisterAnnotationHelper registerAnnotationHelper = new RegisterAnnotationHelper();
    private LoadLibrariesAnnotationsHelper loadLibrariesAnnotationsHelper = new LoadLibrariesAnnotationsHelper();
    private GetAnnotationsFileStreamHelper getAnnotationsFileStreamHelper = new GetAnnotationsFileStreamHelper();
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationHelper.registerAnnotation(registeredAnnotation);
    }
    
    
    @Override
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        loadLibrariesAnnotationsHelper.loadLibrariesAnnotations(librariesConfiguration);
    }
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamHelper.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
    }
}