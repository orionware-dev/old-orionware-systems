package core.annotations.services.registry.impl.tasks;

import java.io.InputStream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.consumers.Consumer1;
import core.functions.Function1x1;

public class LoadLibraryAnnotationsDefinitionsTask extends AnnotationServiceObject implements AnnotationTask
{
    private OrionProperties annotationsDeclarations;
    
    
    public LoadLibraryAnnotationsDefinitionsTask()
    {
        this.annotationsDeclarations = new OrionProperties();
    }
    
    
    public OrionProperties run(LibraryConfiguration libraryConfiguration, Function1x1<String, InputStream> getAnnotationsDefinitionFileStreamMethod, Consumer1<InputStream> closeResourceMethod)
    {
        InputStream libraryAnnotationsFileStream = getAnnotationsDefinitionFileStreamMethod.run(libraryConfiguration.getAnnotationsDefinitionFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        closeResourceMethod.run(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}