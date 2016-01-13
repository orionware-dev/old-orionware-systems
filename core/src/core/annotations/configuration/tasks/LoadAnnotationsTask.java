package core.annotations.configuration.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.Configuration;
import core.configuration.RegisteredAnnotation;
import core.general.Triple;
import core.services.OrionTask;

public class LoadAnnotationsTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    
    
    public Object run(AnnotationsConfigurationService annotationsConfigurationService, Triple<String, String, String> libraryNameAndConfigurationFilePathAndAnnotationsFilePath)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        
        if(libraryNameAndConfigurationFilePathAndAnnotationsFilePath != null)
        {
            if(!haveAnnotationsBeenRegistered(libraryNameAndConfigurationFilePathAndAnnotationsFilePath.getOne()))
            {
                registerAnnotations(libraryNameAndConfigurationFilePathAndAnnotationsFilePath.getOne(), libraryNameAndConfigurationFilePathAndAnnotationsFilePath.getThree());
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
            
            setAnnotationsAsRegistered(libraryName);
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    private boolean haveAnnotationsBeenRegistered(String libraryName)
    {
        if(Configuration.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null)
        {
            return Configuration.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private void setAnnotationsAsRegistered(String libraryName)
    {
        Configuration.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}