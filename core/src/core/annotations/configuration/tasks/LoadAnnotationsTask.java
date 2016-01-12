package core.annotations.configuration.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.Configuration;
import core.configuration.RegisteredAnnotation;
import core.services.OrionTask;

public class LoadAnnotationsTask extends OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    private String libraryAnnotationsFilePath;
    private String libraryName;
    
    
    public Object execute(AnnotationsConfigurationService annotationsConfigurationService, String libraryName, String libraryAnnotationsFilePath)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        this.libraryName = libraryName;
        this.libraryAnnotationsFilePath = libraryAnnotationsFilePath;
        
        if(!haveAnnotationsBeenRegistered())
        {
            registerAnnotations();
        }
        
        return null;
    }
    
    
    private void registerAnnotations()
    {
        try
        {
            Properties annotationsDeclarations = new Properties();
            InputStream libraryAnnotationsFileStream = annotationsConfigurationService.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
            annotationsDeclarations.load(libraryAnnotationsFileStream);
            annotationsConfigurationService.getFileSystemService().closeResource(libraryAnnotationsFileStream);
            
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
            
            setAnnotationsAsRegistered();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    private boolean haveAnnotationsBeenRegistered()
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
    
    
    private void setAnnotationsAsRegistered()
    {
        Configuration.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}