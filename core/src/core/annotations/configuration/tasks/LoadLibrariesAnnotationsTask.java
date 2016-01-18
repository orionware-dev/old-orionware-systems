package core.annotations.configuration.tasks;

import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;
import core.general.OrionProperties;
import core.services.OrionTask;

public class LoadLibrariesAnnotationsTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    
    
    public void run(AnnotationsConfigurationService annotationsConfigurationService, Set<LibraryConfiguration> librariesConfiguration)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        
        if(librariesConfiguration != null)
        {
            for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
            {
                if(libraryConfiguration.getAnnotationsFilePath() != null)
                {
                    if(!haveAnnotationsBeenRegistered(libraryConfiguration.getLibraryName()))
                    {
                        registerAnnotations(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
                        setAnnotationsAsRegistered(libraryConfiguration.getLibraryName());
                    }
                }
            }
        }
    }
    
    
    private void registerAnnotations(String libraryName, String libraryAnnotationsFilePath)
    {
        OrionProperties annotationsDeclarations = new OrionProperties();
        InputStream libraryAnnotationsFileStream = annotationsConfigurationService.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        annotationsConfigurationService.closeResource(libraryAnnotationsFileStream);
        
        if(annotationsDeclarations.isNotEmpty())
        {
            int annotationCounter = 1;
            StringBuilder sb1 = null;
            StringBuilder sb2 = null;
            StringBuilder sb3 = null;
            
            while(annotationsDeclarations.getProperty(libraryName + ".annotation." + annotationCounter) != null)
            {
                sb1 = new StringBuilder();
                sb2 = new StringBuilder();
                sb3 = new StringBuilder();
                sb1.append(libraryName);
                sb1.append(".annotation.");
                sb1.append(annotationCounter);
                sb2.append(libraryName);
                sb2.append(".annotation.service.");
                sb2.append(annotationCounter);
                sb3.append(libraryName);
                sb3.append(".annotation.service.method.to.call.");
                sb3.append(annotationCounter);
                annotationsConfigurationService.registerAnnotation(new RegisteredAnnotation
                    (annotationsDeclarations.getProperty(sb1.toString()),
                    annotationsDeclarations.getProperty(sb2.toString()),
                    annotationsDeclarations.getProperty(sb3.toString())));
                ++annotationCounter;
            }
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