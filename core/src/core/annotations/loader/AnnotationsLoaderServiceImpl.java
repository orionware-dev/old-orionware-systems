package core.annotations.loader;

import java.io.InputStream;
import java.util.Set;
import core.annotations.loader.filestream.GetAnnotationsFileStreamHelper;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.annotations.registry.annotationsdefinitions.RegisterLibraryAnnotationsDefinitionsHelper;
import core.annotations.registry.librariesannotations.RegisterLibrariesAnnotationsHelper;
import core.configuration.LibraryConfiguration;

public class AnnotationsLoaderServiceImpl implements AnnotationsLoaderService
{
    private GetAnnotationsFileStreamHelper getAnnotationsFileStreamHelper = new GetAnnotationsFileStreamHelper();
    
    
    @Override
    public InputStream getAnnotationsFileStream(String libraryName, String libraryAnnotationsFilePath)
    {
        return getAnnotationsFileStreamHelper.run(libraryName, libraryAnnotationsFilePath);
    }
}