package core.annotations.configuration.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.CoreConfiguration;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;
import core.configuration.RegisteredAnnotation;
import core.services.OrionTask;

public class LoadLibrariesAnnotationsTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    
    
    public Object run(AnnotationsConfigurationService annotationsConfigurationService, Set<LibraryConfiguration> librariesConfiguration)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        
        if(librariesConfiguration != null)
        {
            for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
            {
                if(!haveAnnotationsBeenRegistered(libraryConfiguration.getLibraryName()))
                {
                    registerAnnotations(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
                    setAnnotationsAsRegistered(libraryConfiguration.getLibraryName());
                }
            }
        }
        
        return null;
    }
    
    
    private void registerAnnotations(String libraryName, String libraryAnnotationsFilePath)
    {
        try
        {
            Properties annotationsDeclarations = new Properties();
            InputStream libraryAnnotationsFileStream = annotationsConfigurationService.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
            annotationsDeclarations.load(libraryAnnotationsFileStream);
            annotationsConfigurationService.closeResource(libraryAnnotationsFileStream);
            
            if(!annotationsDeclarations.isEmpty())
            {
                int annotationCounter = 1;
                
                while(annotationsDeclarations.getProperty(libraryName + ".annotation." + annotationCounter) != null)
                {
                    annotationsConfigurationService.registerAnnotation(new RegisteredAnnotation
                        (annotationsDeclarations.getProperty(libraryName + ".annotation." + annotationCounter),
                        annotationsDeclarations.getProperty(libraryName + ".annotation.service." + annotationCounter),
                        annotationsDeclarations.getProperty(libraryName + ".annotation.service.method.to.call." + annotationCounter)));
                    ++annotationCounter;
                }
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    private boolean haveAnnotationsBeenRegistered(String libraryName)
    {
        if(LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null)
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private void setAnnotationsAsRegistered(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}